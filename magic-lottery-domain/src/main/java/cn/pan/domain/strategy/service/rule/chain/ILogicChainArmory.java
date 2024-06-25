package cn.pan.domain.strategy.service.rule.chain;

/**
 * @author MrPJSix
 * @description 责任链装配
 * @date 2024/6/24 23:06
 */
public interface ILogicChainArmory {

    ILogicChain next();

    ILogicChain appendNext(ILogicChain next);

}
