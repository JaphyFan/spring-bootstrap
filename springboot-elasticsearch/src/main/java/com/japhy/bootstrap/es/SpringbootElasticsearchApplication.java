package com.japhy.bootstrap.es;

import com.japhy.bootstrap.es.model.Bank;
import com.japhy.bootstrap.es.model.User;
import com.japhy.bootstrap.es.service.UserService;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * SpringbootElasticsearchApplication main class.
 *
 * @author japhy
 */
@SpringBootApplication
@EnableElasticsearchRepositories
@RequiredArgsConstructor
public class SpringbootElasticsearchApplication implements CommandLineRunner {

    private final UserService userService;


    public static void main(String[] args) {
        SpringApplication.run(SpringbootElasticsearchApplication.class, "--debug");
    }

    @Override
    public void run(String... args) throws Exception {
        User user = userService.saveUser(
            User.builder().name("fanflskjdlkjfskljdlfksjdklfjslkdjflskjdflksjflkjskldjfslkdjfklsjdlfksjdlkfjslkdjfklsjdflksjdklfjslkdfjslkdjflksjdflsk"
                + "jdjlfjskdjflksjdlkfjslkjdflksjdlfkjslkfjlskjdflksjldkfjslkjdflksjdlfkjslkdjflskjdlfkjsldkjflskjdlkfjlsjflksjdlkfjslkdjflksjdfklsjlh").time(LocalDateTime.now()).updateTime(LocalDateTime.now())
                .formattedTime(new Date()).test1(LocalDateTime.now()).test3(LocalDateTime.now())
                .test4(ZonedDateTime.now()).flattenedBank(
                Bank.builder().accountNumber(1).address("hangzhou changxing").build())
                .bank(Bank.builder().accountNumber(22222).address("hangzhou huzhou").build())
                .build());

        Optional<User> byUser = userService.findByUser(user.getId());
        byUser.ifPresent(System.out::println);
        SearchHits<User> searchHits = userService.queryAllUsers();
//        searchHits.forEach(userSearchHit -> System.out.println(userSearchHit.getContent()));
//        String s = "{\n"
//            + "    \"Crash type\": \"Java\",\n"
//            + "    \"backtrace\": [\n"
//            + "        \"java.lang.IllegalStateException: Could not execute method for android:onClick\",\n"
//            + "        \"at android.support.v7.app.AppCompatViewInflater$DeclaredOnClickListener.onClick(AppCompatViewInflater.java:293)\",\n"
//            + "        \"at android.view.View.performClick(View.java:7339)\",\n"
//            + "        \"at android.widget.TextView.performClick(TextView.java:14219)\",\n"
//            + "        \"at android.view.View.performClickInternal(View.java:7305)\",\n"
//            + "        \"at android.view.View.access$3200(View.java:846)\",\n"
//            + "        \"at android.view.View$PerformClick.run(View.java:27788)\",\n"
//            + "        \"at android.os.Handler.handleCallback(Handler.java:873)\",\n"
//            + "        \"at android.os.Handler.dispatchMessage(Handler.java:99)\",\n"
//            + "        \"at com.xh.logutils.FireLooper.run(FireLooper.java:76)\",\n"
//            + "        \"at android.os.Handler.handleCallback(Handler.java:873)\",\n"
//            + "        \"at android.os.Handler.dispatchMessage(Handler.java:99)\",\n"
//            + "        \"at android.os.Looper.loop(Looper.java:214)\",\n"
//            + "        \"at android.app.ActivityThread.main(ActivityThread.java:7072)\",\n"
//            + "        \"at java.lang.reflect.Method.invoke(Native Method)\",\n"
//            + "        \"at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:493)\",\n"
//            + "        \"at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:964)\",\n"
//            + "        \"Caused by: java.lang.reflect.InvocationTargetException\",\n"
//            + "        \"at java.lang.reflect.Method.invoke(Native Method)\",\n"
//            + "        \"at android.support.v7.app.AppCompatViewInflater$DeclaredOnClickListener.onClick(AppCompatViewInflater.java:288)\",\n"
//            + "        \"... 15 more\",\n"
//            + "        \"Caused by: java.lang.RuntimeException: test java exception\",\n"
//            + "        \"at xcrash.XCrash.testJavaCrash(XCrash.java:890)\",\n"
//            + "        \"at com.xh.xhsample.business.xcrash.XCrashMainActivity.testJavaCrashInMainThread_onClick(XCrashMainActivity.java:74)\",\n"
//            + "        \"... 17 more\"\n"
//            + "    ],\n"
//            + "    \"deviceMacAddress\": \"A8:2B:B9:78:31:14\",\n"
//            + "    \"sdcardAvailableSpaceSize\": \"14542\",\n"
//            + "    \"sdcardTotalSpaceSize\": \"23845\",\n"
//            + "    \"crashHappenTime\": \"1586847673803\",\n"
//            + "    \"versionName\": \"1.0.10\",\n"
//            + "    \"versionCode\": \"1\",\n"
//            + "    \"buildClassInfo\": {\n"
//            + "        \"BOARD\": \"universal7885\",\n"
//            + "        \"CPU_ABI2\": \"armeabi\",\n"
//            + "        \"HOST\": \"21HHAD14\",\n"
//            + "        \"IS_TREBLE_ENABLED\": \"true\",\n"
//            + "        \"SUPPORTED_64_BIT_ABIS\": \"[Ljava.lang.String;@97f9b5b\",\n"
//            + "        \"CPU_ABI\": \"armeabi-v7a\",\n"
//            + "        \"PERMISSIONS_REVIEW_REQUIRED\": \"false\",\n"
//            + "        \"IS_USERDEBUG\": \"false\",\n"
//            + "        \"DISPLAY\": \"PPR1.180610.011.P200ZCU0ASB3\",\n"
//            + "        \"SUPPORTED_ABIS\": \"[Ljava.lang.String;@d0ff8\",\n"
//            + "        \"FINGERPRINT\": \"samsung\\/wisdomwifizc\\/wisdomwifi:9\\/PPR1.180610.011\\/P200ZCU0ASB3:user\\/release-keys\",\n"
//            + "        \"PRODUCT\": \"wisdomwifizc\",\n"
//            + "        \"ID\": \"PPR1.180610.011\",\n"
//            + "        \"TYPE\": \"user\",\n"
//            + "        \"SERIAL\": \"5200c51446d5c539\",\n"
//            + "        \"IS_CONTAINER\": \"false\",\n"
//            + "        \"IS_ENG\": \"false\",\n"
//            + "        \"DEVICE\": \"wisdomwifi\",\n"
//            + "        \"TIME\": \"1550143930000\",\n"
//            + "        \"IS_USER\": \"true\",\n"
//            + "        \"MODEL\": \"SM-P200\",\n"
//            + "        \"MANUFACTURER\": \"samsung\",\n"
//            + "        \"USER\": \"dpi\",\n"
//            + "        \"BRAND\": \"samsung\",\n"
//            + "        \"SUPPORTED_32_BIT_ABIS\": \"[Ljava.lang.String;@e2f7a6a\",\n"
//            + "        \"HARDWARE\": \"exynos7885\",\n"
//            + "        \"IS_DEBUGGABLE\": \"false\",\n"
//            + "        \"BOOTLOADER\": \"P200ZCU0ASB3\",\n"
//            + "        \"RADIO\": \"unknown\",\n"
//            + "        \"TAG\": \"Build\",\n"
//            + "        \"UNKNOWN\": \"unknown\",\n"
//            + "        \"IS_EMULATOR\": \"false\",\n"
//            + "        \"TAGS\": \"release-keys\"\n"
//            + "    },\n"
//            + "    \"totalMemory\": \"2751\",\n"
//            + "    \"availableMemory\": \"1228\",\n"
//            + "    \"schoolId\": \"2747\",\n"
//            + "    \"packageName\": \"com.xh.xhsample\",\n"
//            + "    \"xhcoreVersionName\": \"3.9.0\",\n"
//            + "    \"recentActivityStack\": \"[com.xh.xhsample.business.xcrash.XCrashMainActivity@4aeac8a9->com.xh.xhsample.business.main.ui.impl.MainActivity@b426c09->]\",\n"
//            + "    \"tinkerPatchVersion\": \"5\",\n"
//            + "    \"recentActivityListString\": \"[com.xh.xhsample.business.main.ui.impl.MainActivity@b426c09->com.xh.xhsample.business.xcrash.XCrashMainActivity@4aeac8a9->]\"\n"
//            + "}";

    }
}
