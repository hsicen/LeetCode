package com.hsicen.core.stack;

import java.util.Stack;

/**
 * <p>作者：Night  2019/3/20 20:46
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：利用栈实现简单的浏览器功能
 */
public class Browser {
    //回退栈
    private Stack<String> backStack;
    //前进栈
    private Stack<String> forwardStack;

    public Browser() {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
    }

    public static void main(String[] args) {
        Browser browser = new Browser();
        browser.open("http://www.baidu.com");
        browser.open("http://news.baidu.com/");
        browser.open("http://news.baidu.com/ent");
        browser.goBack();
        browser.goBack();
        browser.goForward();
        browser.open("http://www.qq.com");
        browser.goForward();
        browser.goBack();
        browser.goForward();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.checkPage();
    }

    /*** 打开新的网页*/
    public void open(String url) {
        backStack.push(url);
        forwardStack.clear();

        System.out.println("open: " + url);
    }

    /*** 回退到上一个页面*/
    public String goBack() {
        if (canBack()) {
            String page = backStack.pop();
            forwardStack.push(page);

            System.out.println("back: " + page);
        }

        System.out.println("error：can't back");
        return null;
    }

    /*** 前进到前一个页面*/
    public String goForward() {
        if (canForward()) {
            String page = forwardStack.pop();
            backStack.push(page);

            System.out.println("forward：" + page);
        }

        System.out.println("error：can't forward");
        return null;
    }

    /*** 显示当前页面*/
    public void checkPage() {
        System.out.println("current：" + backStack.peek());
    }

    /*** 判断能否回退*/
    private boolean canBack() {
        return backStack.size() > 0;
    }

    /*** 判断能否前进*/
    private boolean canForward() {
        return forwardStack.size() > 0;
    }
}
