package cn.pan.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @author MrPJSix
 * @description
 * @date 2024/7/8 23:12
 */
@Data
public class RaffleActivitySku {

    /**
     * 自增ID
     */
    private Long id;

    /**
     * 商品sku
     */
    private Long sku;
    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 活动个人参与次数ID
     */
    private Long activityCountId;
    /**
     * 库存总量
     */
    private Integer stockCount;
    /**
     * 剩余库存
     */
    private Integer stockCountSurplus;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
