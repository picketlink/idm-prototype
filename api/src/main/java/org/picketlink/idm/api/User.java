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
import java.util.Date;
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

   //TODO: Application role - explore and polish the concept more

   //TODO: minimal set of "hard-coded" attributes that make sense:
   //TODO: enabled/disabled
   //TODO: expiration date
   //TODO: Personal - First/Last/Full Name, Phone, Email, Organization, Created Date, Birthdate; Too much??
   
   //TODO: separate UserProfile?
   
   //TODO: for some of those builtin attributes like email proper validation (dedicated exception?) is needed

   //TODO: authentication - password/token validation

   //TODO: non human identity - another interface?

   //TODO: linking identities? Few methods proposed below.




   // Self

   String getName();
   
   
   // Built in attributes
   
   String getFirstName();
   
   void setFirstName(String firstName);
   
   String getLastName();
   
   void setLastName();
   
   //TODO: this one could be configurable with some regex
   String getFullName();
   
   String getEmail();
   
   void setEmail(String email);
   
   boolean isEnabled();
   
   void enable();
   
   void disable();
   
   Date getExpirationDate();
   
   void setExpirationDate(Date expirationDate);
   
   Date getCreationDate();


   // Roles

   void addApplicationRole(Role role, Application application);
   
   void addApplicationRole(String role, String applicationId);
   
   void addRole(Role role, Group group);
   
   void addRole(String role, String groupId);


   //TODO: if we use simply getRoles() then it is not clear if it should return only application roles or any roles
   //TODO: related to any user
   Collection<Role> getAllApplicatonRoles();
   
   Collection<Role> getRoles(Group group);
   
   Collection<Role> getRoles(String groupId);
   
   Collection<Role> getApplcactionRole(Application application);
   
   Collection<Role> getApplicationRole(String applicationId);
   
   Map<Role, Set<Group>> getMembershipsMap();
   
   // TODO: ?? Map<Group, Set<Role>> getMembershipMap() <-- both?

   Collection<Membership> getMemberships();
   
   Collection<Group> getGroups(Role role);
   
   Collection<Group> getGroups(String role);
   
   boolean hasApplicationRole(Role role);
   
   boolean hasApplicationRole(String role);
   
   boolean hasRole(Role role, Group group);
   
   boolean hasRole(String role, String groupId);


   // Authentication
   
   // TODO: token stuff
   // TODO: boolean validateToken(Object token); ???
   // TODO: probably should more belong to separate interface/service. IdentityManager or something different?

   boolean validatePassword(String password);
   
   void updatePassword(String password);


   // Linking
   //TODO: just a proposal. Use cases needed

   void linkUser(User user);

   void unLinkUser(User user);

   Collection<User> getLinkedUsers();


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
