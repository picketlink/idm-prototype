/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.picketlink.idm.api;

import java.util.List;
import java.util.Map;

/**
 * UserQuery
 *
 * @author <a href="mailto:bdawidow@redhat.com">Boleslaw Dawidowicz</a>
 */
public interface UserQuery
{
   //TODO: Javadocs
   //TODO: Exceptions


   // Operations

   UserQuery reset();
   
   UserQuery getImmutable();

   List<User> executeQuery(UserQuery query);


   // Conditions
   
   UserQuery setName(String name);
   
   String getName();
   
   UserQuery setRelatedGroup(Group group);
   
   UserQuery setRelatedGroup(String group);
   
   Group getRelatedGroup();
   
   UserQuery setRole(Role role);
   
   UserQuery setRole(String name);
   
   Role getRole();
   
   UserQuery setAttributeFilter(String name, String[] values);

   Map<String, String[]> getAttributeFilters();

   UserQuery sort(boolean ascending);

   void setRange(Range range);

   Range getRange();

}
