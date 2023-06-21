package org.luoke.ice.util.web.request;

/**
 * @author luoke
 * @date 2022/10/14 12:37
 */
public record HttpRangeData(long start,long end) {
    public long requestSize(long defaultSize) {
        long requestSize = defaultSize;
        if (end != 0 && end > start) {
            requestSize = end - start + 1;
        }
        return requestSize;
    }
}
