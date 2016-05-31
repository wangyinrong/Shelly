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

package xiaofei.library.shelly;

import org.junit.Test;

import xiaofei.library.shelly.function.Function0;
import xiaofei.library.shelly.function.Function1;

/**
 * Created by Xiaofei on 16/5/30.
 */
public class Test01 {

    @Test
    public void case01() {
        Shelly.getDomino("case01")
                .target(new Function0() {
                    @Override
                    public Object call() {
                        return "ok";
                    }
                })
                .with(new Function1() {
                    @Override
                    public Object call(Object input) {
                        ;
                        return ((String) input) + "1";
                    }
                })
                .then(new Function1() {
                    @Override
                    public Object call(Object input) {
                        System.out.println((String) input);
                        return (String) input;
                    }
                }).with(new Function1() {
                    @Override
                    public Object call(Object input) {
                        System.out.println(((String) input) + "with");
                        return null;
                    }
                })
                .commit();
        Shelly.play("case01", "");
    }
}
