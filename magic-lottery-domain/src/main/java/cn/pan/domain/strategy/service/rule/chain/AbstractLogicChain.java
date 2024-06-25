package cn.pan.domain.strategy.service.rule.chain;

/**
 * @author MrPJSix
 * @description 抽奖策略责任链，判断走那种抽奖策略。如；默认抽象、权重抽奖、黑名单抽奖
 * @date 2024/6/24 23:03
 */
public abstract class AbstractLogicChain implements ILogicChain {
    private ILogicChain next;

    @Override
    public ILogicChain next() {
        return next;
    }

    @Override
    public ILogicChain appendNext(ILogicChain next) {
        this.next = next;
        return next;
    }

    protected abstract String ruleModel();
}
