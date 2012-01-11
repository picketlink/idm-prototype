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
package org.picketlink.idm;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * User representation
 *
 * @author <a href="mailto:bdawidow@redhat.com">Boleslaw Dawidowicz</a>
 */
public interface User
{
   //TODO: Javadocs
   //TODO: Exceptions

   // Self

   String getName();
   


   // Roles

   void addApplicationRole(Role role);
   
   void addApplicationRole(String role);
   
   void addRole(Role role, Group group);
   
   void addRole(String role, String group);


   //TODO: if we use simply getRoles() then it is not clear if it should return only application roles or any roles
   //TODO: related to any user
   Collection<Role> getApplicatonRoles();
   
   Collection<Role> getRoles(Group group);
   
   Collection<Role> getRoles(String groupId);
   
   Map<Role, Set<Group>> getMemberships();
   
   boolean hasApplicationRole(Role role);
   
   boolean hasApplicationRole(String role);
   
   boolean hasRole(Role role, Group group);
   
   boolean hasRole(String role, String group);




   // Attributes

   /**
    * Set attribute with given name and value. Operation will overwrite any previous value.
    * Null value will remove attribute.
    *
    * @param name of attribute
    * @param value to be set
    */
   void setAttribute(String name, String value);

   /**
    * Set attribute with given name and values. Operation will overwrite any previous values.
    * Null value or empty array will remove attribute.
    *
    * @param name of attribute
    * @param values to be set
    */
   void setAttribute(String name, String[] values);

   /**
    * Remove attribute with given name
    *
    * @param name of attribute
    */
   void removeAttribute(String name);

   /**
    * @param name of attribute
    * @return attribute values or null if attribute with given name doesn't exist. If given attribute has many values
    * method will return first one
    */
   String getAttribute(String name);

   /**
    * @param name of attribute
    * @return attribute values or null if attribute with given name doesn't exist
    */
   String[] getAttributeValues(String name);

   /**
    * @return map of attribute names and their values
    */
   Map<String, String[]> getAttributes();


}
