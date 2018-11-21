package com.jack.redis.lock.aop.exception;

/**
 * 出错资源
 *
 */
public enum ErrorResource {

    /*系统资源*/
    URL("Url"),

    /* 用户相关 */
    USER_ID("UserId"),
    USER("User"),
    MOBILE("Mobile"),

    /*用户Plus*/
    USER_PLUS_ORDER("UserPlusOrder"),
    USER_PLUS_FREE("UserPlusFree"),
    PLUS_TYPE("PlusType"),

	/* 用户积分相关 */
	POINTSOURCE("PointSource"),
	POINTTYPE("PointType"),

    /* 订单号或代金券号 */
    ORDERSN_PRODUCTSN("OrderSnProductSn"),

    /*优惠券*/
    COUPON("Coupon"),

    /* 订单相关 */
    ORDER("Order"),
    PRODUCT_QUANTITY("ProductQuantity"),
    ORDER_DETAIL("OrderDetail"),
    OUT_OF_DISCOUNT_MONEY("OutOfDiscountMoney"),
    ACTUAL_MONEY("ActualMoney"),
    TOTAL_MONEY("TotalMoney"),

    /**员工相关*/
    EMPLOYEE("Employee"),
    EMPLOYEE_ID("Employee_Id"),
    EMPLOYEE_TYPE("Employee_Type"),
    /**商品相关*/
    PRODUCT("Product"),
	PRODUCT_ID("ProductId"),
	PRODUCT_VERSION("ProductVersion"),
    PRODUCT_SN("ProductSn"),
	AUDIT_STATUS("AuditStatus"),
    /**店铺相关*/
    MERCHANT("Merchant"),
    MERCHANT_DISH("MerchantDish"),
    MERCHANT_FINANCE("MerchantFinance"),
    MERCHANT_VERSION("MerchantVersion"),
    MERCHANT_COMPANY_NAME("MerchantCompanyName"),
    MERCHANT_COMPANY_ADDRESS("MerchantCompanyAddress"),

	/**点赞相关*/
	LIKESOURCE("LikeSource"),

	/**评论的推荐菜相关*/
	COMMENT("Comment"),
	RECOMMEND_DISHES("RecommendDishes"),
	PICTUREIDS("PictureIds"),
	CONTENT("Content");

    private String value;

    ErrorResource(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
