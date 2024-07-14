package cn.pan.types.common;

public class Constants {

    public final static String SPLIT = ",";
    public final static String COLON = ":";
    public final static String SPACE = " ";
    public final static String UNDERLINE = "_";

    /**
     * Redis缓存key前缀标识，
     */
    public static class RedisKey {

        public static String ACTIVITY_KEY = "magic_lottery_activity_key_";
        public static String ACTIVITY_SKU_KEY = "magic_lottery_activity_sku_key_";
        public static String ACTIVITY_COUNT_KEY = "magic_lottery_activity_count_key_";
        public static String STRATEGY_KEY = "magic_lottery_strategy_key_";
        public static String STRATEGY_AWARD_KEY = "magic_lottery_strategy_award_key_";
        public static String STRATEGY_AWARD_LIST_KEY = "magic_lottery_strategy_award_list_key_";
        public static String STRATEGY_RATE_TABLE_KEY = "magic_lottery_strategy_rate_table_key_";
        public static String STRATEGY_RATE_RANGE_KEY = "magic_lottery_strategy_rate_range_key_";
        public static String RULE_TREE_VO_KEY = "magic_lottery_rule_tree_vo_key_";
        public static String STRATEGY_AWARD_COUNT_KEY = "strategy_award_count_key_";
        public static String STRATEGY_AWARD_COUNT_QUERY_KEY = "strategy_award_count_query_key";
        public static String ACTIVITY_SKU_COUNT_QUERY_KEY = "activity_sku_count_query_key";
        public static String ACTIVITY_SKU_STOCK_COUNT_KEY = "activity_sku_stock_count_key_";
        public static String ACTIVITY_SKU_COUNT_CLEAR_KEY = "activity_sku_count_clear_key_";

    }

}
