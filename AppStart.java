

import java.lang.management.MonitorInfo;

import view.MonitorView;

import view.MouseView;
public class AppStart {
    public static void main(String[] args) {
        MouseView.getInstance().run();
    } // main end
} // class end


// 통합할때 최대한 수정하였으나 1,2,3번 메뉴중에 3번만 실행됩니다.