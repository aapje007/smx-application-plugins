/*
 * Copyright 2012 FuseSource
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
 */
package com.fusesource.examples.flights;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class BookingResponseAggregationStrategy implements AggregationStrategy {

	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		if (oldExchange == null) {
			return newExchange;
		} else {
			oldExchange.getIn().setBody(
					oldExchange.getIn().getBody(String.class) + ";" 
					+ newExchange.getIn().getBody(String.class));
			return oldExchange;
		}
	}
}