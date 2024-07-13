package cn.pan.domain.activity.service.quota.rule;

/**
 * @author MrPJSix
 * @description
 * @date 2024/7/9 23:32
 */
public interface IActionChainArmory {

    IActionChain next();

    IActionChain appendNext(IActionChain next);

}
