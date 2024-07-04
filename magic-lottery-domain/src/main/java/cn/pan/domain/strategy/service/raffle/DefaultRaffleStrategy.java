package cn.pan.domain.strategy.service.raffle;

import cn.pan.domain.strategy.model.entity.StrategyAwardEntity;
import cn.pan.domain.strategy.model.valobj.RuleTreeVO;
import cn.pan.domain.strategy.model.valobj.StrategyAwardRuleModelVO;
import cn.pan.domain.strategy.model.valobj.StrategyAwardStockKeyVO;
import cn.pan.domain.strategy.repository.IStrategyRepository;
import cn.pan.domain.strategy.service.AbstractRaffleStrategy;
import cn.pan.domain.strategy.service.IRaffleAward;
import cn.pan.domain.strategy.service.IRaffleStock;
import cn.pan.domain.strategy.service.armory.IStrategyDispatch;
import cn.pan.domain.strategy.service.rule.chain.ILogicChain;
import cn.pan.domain.strategy.service.rule.chain.factory.DefaultChainFactory;
import cn.pan.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import cn.pan.domain.strategy.service.rule.tree.factory.engine.IDecisionTreeEngine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MrPJSix
 * @description 默认的抽奖策略实现
 * @date 2024/6/5 0:02
 */
@Slf4j
@Service
public class DefaultRaffleStrategy extends AbstractRaffleStrategy implements IRaffleStock, IRaffleAward {

    public DefaultRaffleStrategy(IStrategyRepository repository, IStrategyDispatch strategyDispatch, DefaultChainFactory defaultChainFactory, DefaultTreeFactory defaultTreeFactory) {
        super(repository, strategyDispatch, defaultChainFactory, defaultTreeFactory);
    }


    public DefaultChainFactory.StrategyAwardVO raffleLogicChain(String userId, Long strategyId) {
        ILogicChain logicChain = defaultChainFactory.openLogicChain(strategyId);
        return logicChain.logic(userId, strategyId);
    }


    @Override
    public DefaultTreeFactory.StrategyAwardVO raffleLogicTree(String userId, Long strategyId, Integer awardId) {
        StrategyAwardRuleModelVO strategyAwardRuleModelVO = strategyRepository.queryStrategyAwardRuleModelVO(strategyId, awardId);
        if (strategyAwardRuleModelVO == null) {
            return DefaultTreeFactory.StrategyAwardVO.builder().awardId(awardId).build();
        }
        RuleTreeVO ruleTreeVO = strategyRepository.queryRuleTreeVOByTreeId(strategyAwardRuleModelVO.getRuleModels());
        if (ruleTreeVO == null) {
            throw new RuntimeException("存在抽奖策略配置的规则模型 Key，未在库表 rule_tree、rule_tree_node、rule_tree_line 配置对应的规则树信息 " + strategyAwardRuleModelVO.getRuleModels());
        }
        IDecisionTreeEngine treeEngine = defaultTreeFactory.openLogicTree(ruleTreeVO);
        return treeEngine.process(userId, strategyId, awardId);
    }

    @Override
    public StrategyAwardStockKeyVO takeQueueValue() throws InterruptedException {
        return strategyRepository.takeQueueValue();
    }

    @Override
    public void updateStrategyAwardStock(Long strategyId, Integer awardId) {
        strategyRepository.updateStrategyAwardStock(strategyId, awardId);
    }

    @Override
    public List<StrategyAwardEntity> queryRaffleStrategyAwardList(Long strategyId) {
        return strategyRepository.queryStrategyAwardList(strategyId);
    }
}
