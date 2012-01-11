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
 * Group representation
 *
 * @author <a href="mailto:bdawidow@redhat.com">Boleslaw Dawidowicz</a>
 */
public interface Group
{
   //TODO: Javadocs
   //TODO: Exceptions
   
   
   // Self related

   /**
    * Groups are stored in tree hierarchy and therefore ID represents a path. ID string always
    * begins with "/" element that represents root of the tree
    *
    * Example: Valid IDs are "/acme/departments/marketing", "/security/administrator" or "/administrator".
    * Where "acme", "departments", "marketing", "security" and "administrator" are group names.
    *
    * @return Group Id in String representation.
    */
   String getId();

   /**
    * @return group name
    */
   String getName();
   
   
   
   // Sub groups

   /**
    * @return parent group or null if it refers to root ("/") in a group tree.
    */
   Group getParentGroup();

   /**
    * Creates a new child group.
    *
    * @param name
    */
   void createChildGroup(String name);

   /**
    * Removes child group
    *
    * @param group
    */
   void removeChildGroup(Group group);


   /**
    * Removes child group
    *
    * @param name
    */
   void removeChildGroup(String name);

   /**
    * @return child group. Only groups that exist one level below in the tree will be returned.
    */
   Collection<Group> getChildGroups();


   
   // Roles


   void addRole(Role role, User user);
   
   void addRole(String role, String user);
   
   void removeRole(Role role, User user);
   
   void removeRole(String role, String user);
   
   Collection<Role> getRoles(User user);
   
   Collection<Role> getRoles(String user);
   
   Collection<User> getUsers(User user);
   
   Collection<User> getUsers(String user);
   
   Collection<User> getUsersWithRole(Role role);
   
   Collection<User> getUsersWithRole(String role);
   
   Map<Role, Set<User>> getMemberships();

   boolean hasRole(Role role, User user);
   
   boolean hasRole(String role, String user);
   
   
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
