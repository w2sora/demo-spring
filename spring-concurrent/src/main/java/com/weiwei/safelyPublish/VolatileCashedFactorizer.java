package com.weiwei.safelyPublish;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * 使用指向不可变容器对象的volatile类型引用以缓存最新的结果
 */
@ThreadSafe
public class VolatileCashedFactorizer implements Servlet {
    private volatile OneValueCache cache = new OneValueCache(null, null);

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = cache.getFactors(i); // factors局部变量，线程封闭
        if (factors == null) {
            factors = factor(i);
            // OneValueCache不可变对象，对其内部多个数据的读写具有原子性和安全性（final域和构造方法保证），不存在竞态条件
            cache = new OneValueCache(i, factors); // cache只有这一处写操作，由volatile确保可见性
        }
        encodeIntoResponse(resp, factors);
    }

    private BigInteger extractFromRequest(ServletRequest req) {
        // XXX
        return null;
    }

    private void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
        // XXX
    }

    private BigInteger[] factor(BigInteger i) {
        // XXX
        return null;
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

/**
 * 对数值及其因数分解结果进行缓存的不可变容器类
 */
@Immutable
class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger i, BigInteger[] factors) {
        lastNumber = i;
        lastFactors = Arrays.copyOf(factors, factors.length);
    }

    public BigInteger[] getFactors(BigInteger i) {
        if (lastNumber == null || !lastNumber.equals(i)) {
            return null;
        } else {
            return Arrays.copyOf(lastFactors, lastFactors.length);
        }
    }
}
