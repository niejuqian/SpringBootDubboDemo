package com.springboot.dubbo.demo.common.web;

/**
 * 标准响应头
 */
public interface StandardResponseHeader {

    /** 公共 **/
    ResponseHeader SUCCESS = ResponseHeader.newInstance(0, "成功");
    ResponseHeader ERROR = ResponseHeader.newInstance(-1, "系统错误");
    ResponseHeader ERROR_PARAM = ResponseHeader.newInstance(100000, "请求参数有误");
    ResponseHeader ERROR_TOCKEN = ResponseHeader.newInstance(100001, "登录凭证不能为空");
    ResponseHeader ERROR_TOCKEN_EXPIRE = ResponseHeader.newInstance(100002, "登录凭证过期，请重新登录");
    ResponseHeader TASK_CODE_REPEAT = ResponseHeader.newInstance(100003, "任务代码重复");
    ResponseHeader SEND_SMS_FAILE = ResponseHeader.newInstance(100004, "发送短信失败");
    ResponseHeader REQUEST_FAST = ResponseHeader.newInstance(100005, "请求频率过快，请稍后重试");
    ResponseHeader SENSITIVE_LEXICON = ResponseHeader.newInstance(100006, "请求内容包含敏感信息");

    /** 用户模块 10 + 1 + xxx **/
    ResponseHeader USER_LOGIN_FAIL = ResponseHeader.newInstance(101001, "用户登录失败");
    ResponseHeader USER_NOT_EXISTS = ResponseHeader.newInstance(101002, "用户不存在");
    ResponseHeader USER_REGISTERED = ResponseHeader.newInstance(101003, "用户已注册");
    ResponseHeader NICKNAME_IS_EXISTS = ResponseHeader.newInstance(101004, "该昵称已被使用");
    ResponseHeader ERROR_GENERATE_INVITE_CODE = ResponseHeader.newInstance(101005, "生成邀请码时系统繁忙，请稍后重试");
    ResponseHeader INVITE_CODE_NOT_EXIST = ResponseHeader.newInstance(101006, "无效的邀请码");
    ResponseHeader CAMP_TYPE_INVALID = ResponseHeader.newInstance(101007, "无效的阵营参数");
    ResponseHeader SING_REPEAT = ResponseHeader.newInstance(101008, "今日已获取");
    ResponseHeader MOBIL_NOT_REG = ResponseHeader.newInstance(101009, "手机号码未注册");
    ResponseHeader PWD_ERROR = ResponseHeader.newInstance(101010, "登录密码错误");
    ResponseHeader LOGIN_TYPE_INVALID = ResponseHeader.newInstance(101011, "无效的登录方式");
    ResponseHeader USER_STAUS_FAIL = ResponseHeader.newInstance(101012, "用户状态异常，请联系管理员");
    ResponseHeader VERI_CODE_INVALID = ResponseHeader.newInstance(101013, "验证码错误");
    ResponseHeader NICKNAME_LENGTH_OVERTOP = ResponseHeader.newInstance(101014, "昵称长度超出限制");
    ResponseHeader DAY_SHARE_OVERTOP = ResponseHeader.newInstance(101015, "今日分享已达上限，无法继续获得奖励");
    ResponseHeader SETTING_CAMP_REPEAT = ResponseHeader.newInstance(101016, "你已经设置过阵营了");
    ResponseHeader IMAGE_CODE_INVALID = ResponseHeader.newInstance(101018, "图形验证码错误");

    /** 卡牌模块 10 + 2 + xxx **/
    ResponseHeader CUST_NOT_HOLD_CARD = ResponseHeader.newInstance(102001, "用户还未拥有该卡牌");
    ResponseHeader CARD_NOT_EXISTS = ResponseHeader.newInstance(102002, "卡牌不存在");
    ResponseHeader CUST_LUCK_DRAW_TIME_LIMIT = ResponseHeader.newInstance(102003, "还处于限制时间内，不能进行抽奖操作");
    ResponseHeader LUCK_DRAW_CARD_FAIL = ResponseHeader.newInstance(102004, "抽奖失败，未获得奖励");
    ResponseHeader CARD_GROUP_INVALID = ResponseHeader.newInstance(102005, "特殊收集已经过期");


    /** 邮箱模块 10 + 3 + xxx **/
    ResponseHeader MAIL_DEL_TYPE_INVALID = ResponseHeader.newInstance(103001, "无效的删除类型");
    ResponseHeader GET_MAIL_ATTCH_TYPE_INVALID = ResponseHeader.newInstance(103002, "无效的领取附件类型");
    ResponseHeader GET_MAIL_ATTCH_IDS_EMPTY = ResponseHeader.newInstance(103003, "附件ID集合为空");
    ResponseHeader MAIL_NOT_EXISTS = ResponseHeader.newInstance(103004, "邮件不存在");
    ResponseHeader GET_MAIL_NOT_AUTHORITY = ResponseHeader.newInstance(103005, "无权查看其他用户邮件");
    ResponseHeader MAIL_EXT_NOT_EXISTS = ResponseHeader.newInstance(103006, "邮件信息不完整");
    ResponseHeader NOT_GET_MAIL_ATTCH_EXISTS = ResponseHeader.newInstance(103007, "附件已经全部领取完毕");
    ResponseHeader MAIL_ATTACH_GOODS_TYPE_INVALID = ResponseHeader.newInstance(103008, "无效的附件类型");
    ResponseHeader MAIL_ATTACH_GOODS_NUM_REQUIRE = ResponseHeader.newInstance(103009, "附件数量必填");
    ResponseHeader MAIL_SEND_TYPE_INVALID = ResponseHeader.newInstance(103010, "无效的邮件发送类型");
    ResponseHeader RECEIVE_ATTCH_REQ_LIMIT = ResponseHeader.newInstance(103011, "领取附件请求频率过快");
    ResponseHeader ATT_GOODS_ID_REQUIRE = ResponseHeader.newInstance(103012, "附件奖励ID不能为空");
    ResponseHeader ATT_FIC_OVER_TOP = ResponseHeader.newInstance(103013, "附件BOL总量超量，不能发送");
    ResponseHeader ATT_CARD_OVER_TOP = ResponseHeader.newInstance(103014, "附件卡牌总量超量，不能发送");
    ResponseHeader MAIL_TITLE_LENGTH_OVERTOP = ResponseHeader.newInstance(103015, "邮件标题超出长度限制");
    ResponseHeader MAIL_CONTENT_LENGTH_OVERTOP = ResponseHeader.newInstance(103016, "邮件内容超出长度限制");


    /** 账户模块 10 + 4 + xxx **/
    ResponseHeader ACCT_NOT_EXISTS = ResponseHeader.newInstance(104001, "账户不存在");
    ResponseHeader ACCT_TYPE_INVALID = ResponseHeader.newInstance(104002, "无效的账户类型");
    ResponseHeader ACCT_CUST_CARD_GROUP_NOT_EXISTS = ResponseHeader.newInstance(101003, "用户未收集满此特殊图鉴");
    ResponseHeader ACTIVATION_CARD_GROUP_REPEAT = ResponseHeader.newInstance(101004, "重复激活");



    /** 系统公告 10 + 5 + xxx **/


    /** 账户规则 10 + 6 + xxx **/
    ResponseHeader CONFIG_NOT_EXISTS = ResponseHeader.newInstance(106001, "配置信息不存在");

    /** 活动模块 10 + 7 + xxx **/
    ResponseHeader ACTIVITY_NOT_EXISTS = ResponseHeader.newInstance(107001, "活动不存在");
    ResponseHeader ACTIVITY_CONFIG_NOT_EXISTS = ResponseHeader.newInstance(107002, "活动配置不存在");
    ResponseHeader EXCHANGE_CODE_INVALID = ResponseHeader.newInstance(107003, "无效的兑换码");
    ResponseHeader ACTIVITY_END = ResponseHeader.newInstance(107004, "活动已经结束");
    ResponseHeader ACTIVITY_NOT_START = ResponseHeader.newInstance(107005, "活动还未开始");
    ResponseHeader ACTIVITY_INVALID = ResponseHeader.newInstance(107006, "无效的活动");
    ResponseHeader ACTIVITY_NOT_END = ResponseHeader.newInstance(107007, "活动还未结束");
    ResponseHeader EXCHANGE_REWARD_FAIL = ResponseHeader.newInstance(107008, "兑换奖励失败");
    ResponseHeader TAKE_PART_IN_LIMIT = ResponseHeader.newInstance(107009, "您已经达到上限，不能再参与此活动");
    ResponseHeader ACTIVITY_CONFIG_VAL_INVALID = ResponseHeader.newInstance(107010, "配置值格式错误");
    ResponseHeader AV_CONFIG_REWARD_TYPE_INVALID = ResponseHeader.newInstance(107011, "无效的奖励类型");
    ResponseHeader AV_CONFIG_EXISTS = ResponseHeader.newInstance(107012, "活动配置已经存在，不能重复添加");
    ResponseHeader AV_CONFIG_EXCHANGE_CODE_PREFIX_INVALID = ResponseHeader.newInstance(107013, "兑换码前缀配置不正确");
    ResponseHeader AV_CONFIG_NUMBER_TYPE_INVALID = ResponseHeader.newInstance(107014, "活动兑换数量次数长度配置不正确");
    ResponseHeader AV_CONFIG_ORDER_RANK_INVALID = ResponseHeader.newInstance(107015, "邀请类按排名奖励区间范围配置不正确");
    ResponseHeader AV_CONFIG_INVITE_TIME_INVALID = ResponseHeader.newInstance(107016, "邀请类活动设置时间重叠了");
    ResponseHeader AV_RESOURCE_NOT_EXISTS = ResponseHeader.newInstance(107017, "活动资源不存在");
    ResponseHeader AV_STATUS_INVALID = ResponseHeader.newInstance(107018, "无效的活动状态");
    ResponseHeader AV_CONFIG_KEY_INVALID = ResponseHeader.newInstance(107019, "无效的配置");
    ResponseHeader EXCHANGE_REWARD_END = ResponseHeader.newInstance(107020, "奖励已经被领完了");
    ResponseHeader DISTANCE_OVERTOP = ResponseHeader.newInstance(107021, "超出活动范围，兑换失败");
    ResponseHeader ACTIVITY_RS_EXPIRE = ResponseHeader.newInstance(107022, "兑换码被使用或过期");
    ResponseHeader EXCHANGE_CODE_OVERTOP = ResponseHeader.newInstance(107023, "兑换码已经发放完了");
    ResponseHeader EXCHANGE_KEY_WORD_REQUIRE = ResponseHeader.newInstance(107024, "关键字不能为空");
    ResponseHeader GET_EXCHANGE_CODE_FAIL = ResponseHeader.newInstance(107025, "领取失败，请稍后重试");
    ResponseHeader EXCHANGE_THIRD_AV_URL_REQUIRE = ResponseHeader.newInstance(107026, "公众号活动地址不能为空");
    ResponseHeader REWARDS_VAL_EXCHANGE_EXCEPTION= ResponseHeader.newInstance(107027, "奖励值转换异常");
    ResponseHeader WX_AV_RESP_TYPE_REQUIRE= ResponseHeader.newInstance(107028, "回复内容类型不能为空");
    ResponseHeader EXCUANGE_CODE_NUM_OVERTOP= ResponseHeader.newInstance(107029, "兑换码数量过多，请更改兑换码生成时机选项");


    /** 版本检测 10 + 8 + xxx **/
    ResponseHeader OS_TYPE_INVALID = ResponseHeader.newInstance(108001, "无效的系统类型");
    ResponseHeader VERSION_DATA_NOT_EXISTS = ResponseHeader.newInstance(108002, "版本数据不存在");
    ResponseHeader VERSION_CODE_EXISTS = ResponseHeader.newInstance(108003, "版本号已经存在");


    /** 扫码处理 10 + 9 + xxx **/
    ResponseHeader QR_CODE_INVALID = ResponseHeader.newInstance(109001, "无效的二维码");
    ResponseHeader COORD_TYPE_INVALID = ResponseHeader.newInstance(109002, "无效的坐标类型");
    ResponseHeader POINT_REQUIRE = ResponseHeader.newInstance(109003, "坐标参数不能为空");

    /** 消息推送 10 + 10 + xxx **/
    ResponseHeader DEVICE_TYPE_INVALID = ResponseHeader.newInstance(1010001, "无效的设备类型");

    /** 交易市场 10 + 11 + xxx **/
    ResponseHeader PAYMENT_DEPOSIT_REPEAT = ResponseHeader.newInstance(1011001, "已经缴纳过保证金了");
    ResponseHeader NOT_PAYMENT_DEPOSIT = ResponseHeader.newInstance(1011002, "用户未缴纳保证金");
    ResponseHeader MARKET_CONFIG_NOT_EXISTS = ResponseHeader.newInstance(1011003, "缺少配置");
    ResponseHeader CUST_BOL_BALANCE_LOW = ResponseHeader.newInstance(1011004, "用户BOL余额不足");
    ResponseHeader CUST_STALL_OVERTOP = ResponseHeader.newInstance(1011005, "用户摊位使用已达上限");
    ResponseHeader GOODS_REL_ID_REQUIRE = ResponseHeader.newInstance(1011006, "商品关联ID不能为空");
    ResponseHeader GOODS_REL_DATA_NOT_EXISTS = ResponseHeader.newInstance(1011007, "商品关联ID数据不存在");
    ResponseHeader GOODS_TYPE_INVALID = ResponseHeader.newInstance(1011008, "无效的商品类型");
    ResponseHeader CUST_NOT_HAVE_CARD = ResponseHeader.newInstance(1011009, "用户未持有此卡牌");
    ResponseHeader CUST_CARD_NUM_LOW = ResponseHeader.newInstance(1011010, "用户此卡牌数量不足");
    ResponseHeader GOODS_NOT_EXISTS = ResponseHeader.newInstance(1011011, "商品不存在");
    ResponseHeader NOT_REFUND_DEPOSIT = ResponseHeader.newInstance(1011012, "摊位不为空，不能退保证金");
    ResponseHeader PAY_PARAM_NOT_NULL = ResponseHeader.newInstance(1011013, "支付请求参数不能为空");
    ResponseHeader PAY_TYPE_INVALID = ResponseHeader.newInstance(1011014, "无效的支付类型");
    ResponseHeader CREATE_ORDER_NOT_NULL = ResponseHeader.newInstance(1011015, "下单请求参数不能为空");
    ResponseHeader CUST_STATUS_NOT_TRADE = ResponseHeader.newInstance(1011016, "用户状态异常，不能进行交易");
    ResponseHeader ORDER_GOODS_INVALID = ResponseHeader.newInstance(1011017, "您购买的商品已不存在");
    ResponseHeader ORDER_NOT_EXISTS = ResponseHeader.newInstance(1011018, "订单不存在");
    ResponseHeader ORDER_PAY_END = ResponseHeader.newInstance(1011019, "订单已经支付完全，无需在进行支付");
    ResponseHeader ORDER_STATUS_ERR = ResponseHeader.newInstance(1011020, "订单状态异常，无法进行支付");
    ResponseHeader PAY_FAIL = ResponseHeader.newInstance(1011021, "商品购买失败");
    ResponseHeader AVAILABLE_BALANCE_LOW_NOT_PAY = ResponseHeader.newInstance(1011022, "余额不足，支付失败");
    ResponseHeader NOT_PAY_SELF_GOODS = ResponseHeader.newInstance(1011023, "不能购买自己的商品");
    ResponseHeader PAY_GOODS_NUM_FAIL = ResponseHeader.newInstance(1011024, "您购买的商品数量不足");
    ResponseHeader ORDER_ORIGIN_INVALID = ResponseHeader.newInstance(1011025, "无效的订单来源");



}
