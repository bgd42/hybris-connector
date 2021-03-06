/*******************************************************************************
 * Copyright 2016 Fredhopper B.V.
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
 *******************************************************************************/
package com.fredhopper.connector.index.populator;

import de.hybris.platform.catalog.model.classification.ClassificationClassModel;
import de.hybris.platform.category.model.CategoryModel;

import java.util.Optional;


/**
 * It returns the first supercategory which is not a Classification Class
 */
public class DefaultParentCategoryResolver implements ParentCategoryResolver
{

	@Override
	public Optional<CategoryModel> resolve(final CategoryModel category)
	{
		for (final CategoryModel superCategory : category.getSupercategories())
		{
			if (!(superCategory instanceof ClassificationClassModel))
			{
				return Optional.of(superCategory);
			}
		}
		return Optional.empty();
	}

}
