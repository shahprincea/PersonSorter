/*
 * Copyright [yyyy] [name of copyright owner]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pojo.utils.comparator;

import pojo.Person;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by prince on 10/6/16.
 * <p>
 * Custom comparator which sorts person based on person's Height
 */
public class HeightInComparator implements Comparator<Person>, Serializable {

    @Override
    public int compare(Person p1, Person p2) {
        return Double.compare(p1.getHeightIn(), p2.getHeightIn());
    }
}