/**
 *  Copyright (c) 2009-2010 Misys Open Source Solutions (MOSS) and others
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied. See the License for the specific language governing
 *  permissions and limitations under the License.
 *
 *  Contributors:
 *    Misys Open Source Solutions - initial API and implementation
 *    -
 */

package org.openhealthtools.openxds.webapp.control;

import java.util.ArrayList;


import org.apache.axiom.om.OMElement;

/**
 * This class builds GetDocument query.
 * @author <a href="anilkumar.reddy@misys.com">Anil Kumar</a>
 */
public class GetDocument extends Sq {
	ArrayList<String> ids = null;

	String query_details() {
		return "GetDocument " + ids;
	}
	
	OMElement build(ArrayList<String> ids) {
		this.ids = ids;
		ArrayList<OMElement> query = build_query_wrapper("urn:uuid:5c4f972b-d56b-40ac-a5fc-c8ca9b40b9d4");
		if (ids.get(0).startsWith("urn:uuid:")) 
			add_slot(query, "$XDSDocumentEntryEntryUUID", this.query_array_list(ids));
		else
			add_slot(query, "$XDSDocumentEntryUniqueId", this.query_array_list(ids));
		return query.get(0);
	}

}
