package com.example.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义过滤器
 */
@Component
public class AuthFilter extends ZuulFilter {
    /**
     * @return
     *     pre：路由之前
     *     routing：路由之时
     *     post： 路由之后
     *     error：发送错误调用
     *     filterOrder：过滤的顺序
     *     shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     *     run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 优先级，越小越级别高
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        //请求特定url时执行鉴权
        if ("/we1/cart/query".equals(request.getRequestURI())){
            return true;
        }
        return false;
    }

    /**
     * 如何鉴权
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        if("111".equals(request.getHeader("auth"))){
            context.setSendZuulResponse(false); //这不予放行
            context.setResponseStatusCode(205);  //返回一个http状态码
        }
        return null;
    }
}
