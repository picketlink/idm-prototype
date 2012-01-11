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
import java.util.List;

/**
 * IdentityManager
 *
 * @author <a href="mailto:bdawidow@redhat.com">Boleslaw Dawidowicz</a>
 */
public interface IdentityManager
{
   //TODO: Javadocs
   //TODO: Exceptions
   
   
   // User
   
   User createUser(String name);
   
   void removeUser(User user);
   
   void removeUser(String name);
   
   User getUser(String name);
   
   Collection<User> getUsers();
   
   
   
   // Group 
   
   Group createGroup(String id);
   
   Group createGroup(String id, Group parent);
   
   Group createGroup(String id, String parent);
   
   void removeGroup(Group group);
   
   void removeGroup(String group);
   
   Group getGroup(String group);
   
   Group getGroup(String group, Group parent);
   
   Collection<Group> getGroups();
   
   
   
   // Roles
   
   Role createRole(String name);
   
   void removeRole(Role role);
   
   void removeRole(String name);
   
   Role getRole(String name);
   
   Collection<Role> getRoles();
   
   Collection<Role> getRoles(User user, Group group);
   
   Collection<Role> getRoles(String user, String group);
  

   // Queries

   UserQuery createUserQuery();
   
   GroupQuery createGroupQuery();
   
   RoleQuery createRoleQuery();
   
   MembershipQuery createMembershipQuery();
   
   List<User> executeQuery(UserQuery query);
   
   List<User> executeQuery(UserQuery query, Range range);
   
   List<Group> executeQuery(GroupQuery query);
   
   List<Group> executeQuery(GroupQuery query, Range range);
   
   List<Role> executeQuery(RoleQuery query);
   
   List<Role> executeQuery(RoleQuery query, Range range);
   
   List<Membership> executeQuery(MembershipQuery query);
   
   List<Membership> executeQuery(MembershipQuery query, Range range);
   
}
