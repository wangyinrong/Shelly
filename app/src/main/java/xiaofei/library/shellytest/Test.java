/**
 *
 * Copyright 2016 Xiaofei
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package xiaofei.library.shellytest;

import xiaofei.library.shelly.Shelly;
import xiaofei.library.shelly.function.Action0;
import xiaofei.library.shelly.function.Function1;
import xiaofei.library.shelly.function.TargetAction1;

/**
 * Created by Xiaofei on 16/6/1.
 */
public class Test {
    public static void init() {
        Shelly.<String>createDomino(1)
                .backgroundQueue()
                .target(new Action0() {
                    @Override
                    public void call() {
                        try {
                            Thread.sleep(10000);
                            System.out.println("Haha");
                        } catch (InterruptedException e) {

                        }
                    }
                })
                .map(new Function1<String, String>() {
                    @Override
                    public String call(String input) {
                        return input + "map";
                    }
                })
                .uiThread()
                .target(MainActivity.class, new TargetAction1<MainActivity, String>() {
                    @Override
                    public void call(MainActivity mainActivity, String input) {
                        mainActivity.f(input);
                    }
                }).commit();
    }
}
