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

import java.util.Comparator;

/**
 * Created by prince on 10/6/16.
 */
public class DateOfBirthComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o2.getDateOfBirth().compareTo(o1.getDateOfBirth());
    }
}
