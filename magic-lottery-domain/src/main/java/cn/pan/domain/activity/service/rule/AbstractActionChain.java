package cn.pan.domain.activity.service.rule;

/**
 * @author MrPJSix
 * @description
 * @date 2024/7/9 23:34
 */
public abstract class AbstractActionChain implements IActionChain {

    private IActionChain next;

    @Override
    public IActionChain next() {
        return next;
    }

    @Override
    public IActionChain appendNext(IActionChain next) {
        this.next = next;
        return next;
    }

}
