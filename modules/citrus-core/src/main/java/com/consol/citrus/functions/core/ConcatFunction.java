/*
 * Copyright 2006-2010 the original author or authors.
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

package com.consol.citrus.functions.core;

import com.consol.citrus.context.TestContext;
import com.consol.citrus.exceptions.InvalidFunctionUsageException;
import com.consol.citrus.functions.Function;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Function concatenating multiple tokens to a single string. Tokens can be either
 * static string values or dynamic variables or functions.
 * 
 * @author Christoph Deppisch
 */
public class ConcatFunction implements Function {

    /**
     * @see com.consol.citrus.functions.Function#execute(java.util.List, com.consol.citrus.context.TestContext)
     * @throws InvalidFunctionUsageException
     */
    public String execute(List<String> parameterList, TestContext context) {
        if (CollectionUtils.isEmpty(parameterList)) {
            throw new InvalidFunctionUsageException("Function parameters must not be empty");
        }

        StringBuffer resultString = new StringBuffer();

        for (int i = 0; i < parameterList.size(); i++) {
            resultString.append(parameterList.get(i));
        }

        return resultString.toString();
    }

}
