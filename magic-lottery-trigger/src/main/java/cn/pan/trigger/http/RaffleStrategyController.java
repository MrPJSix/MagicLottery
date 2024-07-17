package cn.pan.trigger.http;

import cn.pan.domain.activity.service.IRaffleActivityAccountQuotaService;
import cn.pan.domain.strategy.model.entity.RaffleAwardEntity;
import cn.pan.domain.strategy.model.entity.RaffleFactorEntity;
import cn.pan.domain.strategy.model.entity.StrategyAwardEntity;
import cn.pan.domain.strategy.model.valobj.RuleWeightVO;
import cn.pan.domain.strategy.service.IRaffleAward;
import cn.pan.domain.strategy.service.IRaffleRule;
import cn.pan.domain.strategy.service.IRaffleStrategy;
import cn.pan.domain.strategy.service.armory.IStrategyArmory;
import cn.pan.trigger.api.IRaffleStrategyService;
import cn.pan.trigger.api.dto.*;
import cn.pan.types.enums.ResponseCode;
import cn.pan.types.exception.AppException;
import cn.pan.types.model.Response;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author MrPJSix
 * @description 营销抽奖服务HTTP接口
 * @date 2024/7/4 22:46
 */
@Slf4j
@RestController
@CrossOrigin("${app.config.cross-origin}")
@RequestMapping("/api/${app.config.api-version}/raffle/")
public class RaffleStrategyController implements IRaffleStrategyService {

    @Resource
    private IRaffleAward raffleAward;
    @Resource
    private IRaffleStrategy raffleStrategy;
    @Resource
    private IStrategyArmory strategyArmory;
    @Resource
    private IRaffleRule raffleRule;
    @Resource
    private IRaffleActivityAccountQuotaService raffleActivityAccountQuotaService;

    /**
     * 策略装配，将策略信息装配到缓存中
     * <a href="http://localhost:8091/api/v1/raffle/strategy_armory">/api/v1/raffle/strategy_armory</a>
     *
     * @param strategyId 策略ID
     * @return 装配结果
     */
    @GetMapping("strategy_armory")
    @Override
    public Response<Boolean> strategyArmory(@RequestParam Long strategyId) {
        try {
            log.info("抽奖策略装配开始 strategyId：{}", strategyId);
            boolean armoryStatus = strategyArmory.assembleLotteryStrategy(strategyId);
            Response<Boolean> response = Response.<Boolean>builder()
                    .code(ResponseCode.SUCCESS.getCode())
                    .info(ResponseCode.SUCCESS.getInfo())
                    .data(armoryStatus)
                    .build();
            log.info("抽奖策略装配完成 strategyId：{} response: {}", strategyId, JSON.toJSONString(response));
            return response;
        } catch (Exception e) {
            log.error("抽奖策略装配失败 strategyId：{}", strategyId, e);
            return Response.<Boolean>builder()
                    .code(ResponseCode.UN_ERROR.getCode())
                    .info(ResponseCode.UN_ERROR.getInfo())
                    .build();
        }
    }

    /**
     * 查询奖品列表
     * <a href="http://localhost:8091/api/v1/raffle/query_raffle_award_list">/api/v1/raffle/query_raffle_award_list</a>
     * 请求参数 raw json
     *
     * @param request {"strategyId":1000001}
     * @return 奖品列表
     */

    @PostMapping("query_raffle_award_list")
    @Override
    public Response<List<RaffleAwardListResponseDTO>> queryRaffleAwardList(@RequestBody RaffleAwardListRequestDTO request) {
        try {
            log.info("查询抽奖奖品列表配开始 userId:{} activityId：{}", request.getUserId(), request.getActivityId());
            // 1. 参数校验
            if (StringUtils.isBlank(request.getUserId()) || null == request.getActivityId()) {
                throw new AppException(ResponseCode.ILLEGAL_PARAMETER.getCode(), ResponseCode.ILLEGAL_PARAMETER.getInfo());
            }
            // 2. 查询奖品配置
            List<StrategyAwardEntity> strategyAwardEntities = raffleAward.queryRaffleStrategyAwardListByActivityId(request.getActivityId());
            // 3. 获取规则配置
            String[] treeIds = strategyAwardEntities.stream()
                    .map(StrategyAwardEntity::getRuleModels)
                    .filter(ruleModel -> ruleModel != null && !ruleModel.isEmpty())
                    .toArray(String[]::new);
            // 4. 查询规则配置 - 获取奖品的解锁限制，抽奖N次后解锁
            Map<String, Integer> ruleLockCountMap = raffleRule.queryAwardRuleLockCount(treeIds);
            // 5. 查询抽奖次数 - 用户已经参与的抽奖次数
            Integer dayPartakeCount = raffleActivityAccountQuotaService.queryRaffleActivityAccountDayPartakeCount(request.getActivityId(), request.getUserId());
            // 6. 遍历填充数据
            List<RaffleAwardListResponseDTO> raffleAwardListResponseDTOS = new ArrayList<>(strategyAwardEntities.size());
            for (StrategyAwardEntity strategyAward : strategyAwardEntities) {
                Integer awardRuleLockCount = ruleLockCountMap.get(strategyAward.getRuleModels());
                raffleAwardListResponseDTOS.add(RaffleAwardListResponseDTO.builder()
                                .awardId(strategyAward.getAwardId())
                                .awardTitle(strategyAward.getAwardTitle())
                                .awardSubtitle(strategyAward.getAwardSubtitle())
                                .sort(strategyAward.getSort())
                                .awardRuleLockCount(awardRuleLockCount)
                                .isAwardUnlock(null == awardRuleLockCount || dayPartakeCount >= awardRuleLockCount)
                                .waitUnLockCount(null == awardRuleLockCount || awardRuleLockCount <= dayPartakeCount ? 0 : awardRuleLockCount - dayPartakeCount)
                                .build());
            }
            Response<List<RaffleAwardListResponseDTO>> response = Response.<List<RaffleAwardListResponseDTO>>builder()
                                                                            .code(ResponseCode.SUCCESS.getCode())
                                                                            .info(ResponseCode.SUCCESS.getInfo())
                                                                            .data(raffleAwardListResponseDTOS)
                                                                            .build();
            log.info("查询抽奖奖品列表配置完成 userId:{} activityId：{} response: {}", request.getUserId(), request.getActivityId(), JSON.toJSONString(response));
            // 返回结果
            return response;
        } catch (Exception e) {
            log.error("查询抽奖奖品列表配置失败 userId:{} activityId：{}", request.getUserId(), request.getActivityId(), e);
            return Response.<List<RaffleAwardListResponseDTO>>builder()
                    .code(ResponseCode.SUCCESS.getCode())
                    .info(ResponseCode.SUCCESS.getInfo())
                    .build();
        }
    }

    /**
     * curl --request POST \
     * --url http://localhost:8091/api/v1/raffle/strategy/query_raffle_strategy_rule_weight \
     * --header 'content-type: application/json' \
     * --data '{
     * "userId":"MrPJSix",
     * "activityId": 100301
     * }'
     */
    @RequestMapping(value = "query_raffle_strategy_rule_weight", method = RequestMethod.POST)
    @Override
    public Response<List<RaffleStrategyRuleWeightResponseDTO>> queryRaffleStrategyRuleWeight(RaffleStrategyRuleWeightRequestDTO request) {
        try {
            log.info("查询抽奖策略权重规则配置开始 userId:{} activityId：{}", request.getUserId(), request.getActivityId());
            // 1. 参数校验
            if (StringUtils.isBlank(request.getUserId()) || null == request.getActivityId()) {
                throw new AppException(ResponseCode.ILLEGAL_PARAMETER.getCode(), ResponseCode.ILLEGAL_PARAMETER.getInfo());
            }
            // 2. 查询用户抽奖总次数
            Integer userActivityAccountTotalUseCount = raffleActivityAccountQuotaService.queryRaffleActivityAccountPartakeCount(request.getActivityId(), request.getUserId());
            // 3. 查询规则
            List<RaffleStrategyRuleWeightResponseDTO> raffleStrategyRuleWeightList = new ArrayList<>();
            List<RuleWeightVO> ruleWeightVOList = raffleRule.queryAwardRuleWeightByActivityId(request.getActivityId());
            for (RuleWeightVO ruleWeightVO : ruleWeightVOList) {
                // 转换对象
                List<RaffleStrategyRuleWeightResponseDTO.StrategyAward> strategyAwards = new ArrayList<>();
                List<RuleWeightVO.Award> awardList = ruleWeightVO.getAwardList();
                for (RuleWeightVO.Award award : awardList) {
                    RaffleStrategyRuleWeightResponseDTO.StrategyAward strategyAward = new RaffleStrategyRuleWeightResponseDTO.StrategyAward();
                    strategyAward.setAwardId(award.getAwardId());
                    strategyAward.setAwardTitle(award.getAwardTitle());
                    strategyAwards.add(strategyAward);
                }
                // 封装对象
                RaffleStrategyRuleWeightResponseDTO raffleStrategyRuleWeightResponseDTO = new RaffleStrategyRuleWeightResponseDTO();
                raffleStrategyRuleWeightResponseDTO.setRuleWeightCount(ruleWeightVO.getWeight());
                raffleStrategyRuleWeightResponseDTO.setStrategyAwards(strategyAwards);
                raffleStrategyRuleWeightResponseDTO.setUserActivityAccountTotalUseCount(userActivityAccountTotalUseCount);

                raffleStrategyRuleWeightList.add(raffleStrategyRuleWeightResponseDTO);
            }
            Response<List<RaffleStrategyRuleWeightResponseDTO>> response = Response.<List<RaffleStrategyRuleWeightResponseDTO>>builder()
                    .code(ResponseCode.SUCCESS.getCode())
                    .info(ResponseCode.SUCCESS.getInfo())
                    .data(raffleStrategyRuleWeightList)
                    .build();
            log.info("查询抽奖策略权重规则配置完成 userId:{} activityId：{} response: {}", request.getUserId(), request.getActivityId(), JSON.toJSONString(response));
            return response;
        } catch (Exception e) {
            log.error("查询抽奖策略权重规则配置失败 userId:{} activityId：{}", request.getUserId(), request.getActivityId(), e);
            return Response.<List<RaffleStrategyRuleWeightResponseDTO>>builder()
                    .code(ResponseCode.UN_ERROR.getCode())
                    .info(ResponseCode.UN_ERROR.getInfo())
                    .build();
        }
    }


    /**
     * 随机抽奖接口
     * <a href="http://localhost:8091/api/v1/raffle/random_raffle">/api/v1/raffle/random_raffle</a>
     *
     * @param request 请求参数 {"strategyId":1000001}
     * @return 抽奖结果
     */
    @PostMapping("random_raffle")
    @Override
    public Response<RaffleStrategyResponseDTO> randomRaffle(@RequestBody RaffleStrategyRequestDTO request) {
        try {
            log.info("随机抽奖开始 strategyId: {}", request.getStrategyId());
            // 调用抽奖接口
            RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(RaffleFactorEntity.builder()
                    .userId("system")
                    .strategyId(request.getStrategyId())
                    .build());
            // 封装返回结果
            Response<RaffleStrategyResponseDTO> response = Response.<RaffleStrategyResponseDTO>builder()
                    .code(ResponseCode.SUCCESS.getCode())
                    .info(ResponseCode.SUCCESS.getInfo())
                    .data(RaffleStrategyResponseDTO.builder()
                            .awardId(raffleAwardEntity.getAwardId())
                            .awardIndex(raffleAwardEntity.getSort())
                            .build())
                    .build();
            log.info("随机抽奖完成 strategyId: {} response: {}", request.getStrategyId(), JSON.toJSONString(response));
            return response;
        } catch (AppException e) {
            log.error("随机抽奖失败 strategyId：{} {}", request.getStrategyId(), e.getInfo());
            return Response.<RaffleStrategyResponseDTO>builder()
                    .code(e.getCode())
                    .info(e.getInfo())
                    .build();
        } catch (Exception e) {
            log.error("随机抽奖失败 strategyId：{}", request.getStrategyId(), e);
            return Response.<RaffleStrategyResponseDTO>builder()
                    .code(ResponseCode.UN_ERROR.getCode())
                    .info(ResponseCode.UN_ERROR.getInfo())
                    .build();
        }
    }
}
