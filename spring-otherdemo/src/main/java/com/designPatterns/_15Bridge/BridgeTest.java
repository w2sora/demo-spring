package com.designPatterns._15Bridge;

public class BridgeTest {
    public static void main(String[] args) {
        Bridge bridge = new MyBridge();

        /* 调用第一个对象 */
        SourceSub1 sub1 = new SourceSub1();
        bridge.setSource(sub1);
        bridge.method();

        /* 调用第二个对象 */
        SourceSub2 sub2 = new SourceSub2();
        bridge.setSource(sub2);
        bridge.method();
    }
}
