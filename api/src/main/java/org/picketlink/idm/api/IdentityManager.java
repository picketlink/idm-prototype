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

import java.util.Collection;

/**
 * IdentityManager
 *
 * @author <a href="mailto:bdawidow@redhat.com">Boleslaw Dawidowicz</a>
 */
public interface IdentityManager
{
   //TODO: Javadocs

   //TODO: Exceptions
   //TODO: Exception hierarchy from generic IdentityException vs one interface + error codes. Probably both.

   //TODO: control hooks & events

   //TODO: linking identities

   //TODO: authentication

   //TODO: basic permissions?
   
   
   // User
   
   User createUser(String name);
   
   void removeUser(User user);
   
   void removeUser(String name);
   
   User getUser(String name);
   
   Collection<User> getAllUsers();
   
   
   
   // Group 
   
   Group createGroup(String id);
   
   Group createGroup(String id, Group parent);
   
   Group createGroup(String id, String parent);
   
   void removeGroup(Group group);
   
   void removeGroup(String groupId);
   
   Group getGroup(String groupId);
   
   Group getGroup(String groupId, Group parent);
   
   Collection<Group> getAllGroups();
   
   
   
   // Roles
   
   Role createRole(String name);
   
   void removeRole(Role role);
   
   void removeRole(String name);
   
   Role getRole(String name);
   
   Collection<Role> getAllRoles();
   
   Collection<Role> getRoles(User user, Group group);
   
   Collection<Role> getRoles(String user, String groupId);

   Collection<Role> getApplicationRoles(User user, Application application);

   Collection<Role> getApplicationRoles(String user, String applicationId);

   boolean hasRole(Role role, User user, Group group);
   
   boolean hasRole(String role, String user, String groupId);

   boolean hasApplicationRole(Role role, User user, Application application);

   boolean hasApplicationRole(String role, String user, String applicationId);


   // Application

   Application createApplication(String applicationId);

   void removeApplication(Application application);

   void removeApplication(String applicationId);

   Application getApplication(String applicationId);

   Collection<Application> getAllApplications();


   // Queries

   UserQuery createUserQuery();
   
   GroupQuery createGroupQuery();
   
   ApplicationQuery createApplicationQuery();
   
   RoleQuery createRoleQuery();
   
   MembershipQuery createMembershipQuery();

}
