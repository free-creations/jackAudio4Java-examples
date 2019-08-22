/*
 * Copyright 2019 Harald Postner.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package showVersions;

import jackAudio4Java.Jack;
import jackAudio4Java.types.Int;

/**
 *
 */
public class App {



    public String getJniVersion(){
        return String.format("%h",Jack.server().jni_get_version());
    }

    public String getJackVersion(){
        Int major = new Int(-1);
        Int minor = new Int(-1);
        Int micro = new Int(-1);
        Int proto = new Int(-1);
        Jack.server().jack_get_version(major, minor, micro, proto);
        return String.format("%d.%d.%d-%d",major.value, minor.value, micro.value, proto.value);
    }
    public static void main(String[] args) {
        App app = new App();

        System.out.println("=== Java Native Interface version: "+ app.getJniVersion());
        System.out.println("=== Jack Audio Server version: "+ app.getJackVersion());

    }
}
