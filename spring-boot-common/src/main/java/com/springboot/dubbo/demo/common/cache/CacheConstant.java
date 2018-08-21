package com.springboot.dubbo.demo.common.cache;

/**
 * 缓存名称常量定义
 * Created by Benson on 2018/3/28.
 */
public interface CacheConstant {
    /**接口请求访问频率控制*/
    String REQUEST_CONTROL_CACHE = "request_control_cache";

    // 登录用户tokenCache
    String TOKEN_SESSION_CACHE = "token_session_cache";

    // 登录用户token
    String USER_TOKEN_CACHE = "user_token";

    // 发送短信cache
    String SMS_CODE_CACHE = "sms_code_cache";

    // 图形验证码cache
    String IMAGE_CODE_CACHE = "image_code_cache";

    // 公共参数
    String PUB_PARAM_CACHE = "pub_param";

    String RANK_ACCT = "rank_acct";

    String RANK_CARD = "rank_card";

    /**账户规则配置列表缓存key*/
    String ACT_CONFIG = "act_config";

    /**账户规则配置单个缓存key*/
    String ACT_CONFIG_SINGLETON = "act_config_singleton";

    /**客户领取邮件附件频率限制缓存key*/
    String RECEIVE_ATTACH_LIMIT = "receive_attach_limit";

    /**版本缓存*/
    String PUB_APP_VERSION = "pub_app_version";

    /**活动奖励发放频率控制缓存*/
    String SEND_ACTIVITY_REWARD = "send_activity_reward";

    /**活动奖励发放频率控制缓存 key*/
    String SEND_ACTIVITY_REWARD_KEY = "send_activity_reward_key";

    /**卡牌列表*/
    String CARD_INFO_LIST = "card_info_list";

    /**卡牌列表缓存key*/
    String CARD_INFO_CACHE_KEY = "card_info_cache_key";

    /**发送邮件限制*/
    String SEND_MAIL_LIMIT = "send_mail_limit";

    /**发送邮件限制*/
    String SEND_MAIL_LIMIT_KEY = "send_mail_limit_key";

    /**用户持有卡牌*/
    String CUST_CARD_LIST_CACHE = "cust_card_list_cache";

    /**微信开放平台校验凭证缓存*/
    String WX_OPEN_Verify_Ticket = "wx_open_verify_ticket";

    /**微信开放平台预授码缓存*/
    String WX_OPEN_PRE_AUTH_CODE = "wx_open_pre_auth_code";

    /**微信开放平台AccessToken*/
    String WX_OPEN_ACCESS_TOKEN = "wx_open_access_token";

    /**微信公众号授权令牌缓存*/
    String WX_AUTHORIZER_ACCESS_TOKEN = "wx_authorizer_access_token";

    /**活动配置缓存*/
    String AV_CONFIG_CACHE = "av_config_cache";

}
