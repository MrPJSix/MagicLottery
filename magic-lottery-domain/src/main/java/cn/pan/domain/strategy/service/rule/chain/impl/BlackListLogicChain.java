package cn.pan.domain.strategy.service.rule.chain.impl;

import cn.pan.domain.strategy.repository.IStrategyRepository;
import cn.pan.domain.strategy.service.rule.chain.AbstractLogicChain;
import cn.pan.types.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author MrPJSix
 * @description 黑名单责任链
 * @date 2024/6/24 23:04
 */
@Slf4j
@Component("rule_blacklist")
public class BlackListLogicChain extends AbstractLogicChain {

    @Resource
    private IStrategyRepository strategyRepository;

    @Override
    public Integer logic(String userId, Long strategyId) {
        log.info("抽奖责任链-黑名单开始 userId: {} strategyId: {} ruleModel: {}", userId, strategyId, ruleModel());

        // 查询规则配置
        String ruleValue = strategyRepository.queryStrategyRuleValue(strategyId, ruleModel());
        String[] spliteRuleValue = ruleValue.split(Constants.COLON);
        Integer awardId = Integer.parseInt(spliteRuleValue[0]);

        // 黑名单抽奖判断
        String[] userBlackIds = spliteRuleValue[1].split(Constants.SPLIT);
        for (String userBlackId : userBlackIds) {
            if (userId.equals(userBlackId)) {
                log.info("抽奖责任链-黑名单接管 userId: {} strategyId: {} ruleModel: {} awardId: {}", userId, strategyId, ruleModel(), awardId);
                return awardId;
            }
        }

        // 过滤其他责任链
        log.info("抽奖责任链-黑名单放行 userId: {} strategyId: {} ruleModel: {}", userId, strategyId, ruleModel());
        return next().logic(userId, strategyId);
    }

    @Override
    protected String ruleModel() {
        return "rule_blacklist";
    }
}
