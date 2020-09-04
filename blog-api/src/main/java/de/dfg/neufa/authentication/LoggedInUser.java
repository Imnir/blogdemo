/**
 * 
 * Deutsche Forschungsgemeinschaft e.V.
 *
 * Projekt: neufa-antrag-ui
 * Datum: 14.04.2020
 * @author schulze
 * 
 * Copyright (c) 2020, All rights reserved. 
 * 
 **/
package de.dfg.neufa.authentication;

import java.security.Principal;
import java.util.Map;
import java.util.logging.Logger;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.SecurityContext;


/**
 * The Class LoggedInUser.
 */

public class LoggedInUser {

    /** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(LoggedInUser.class.getName());

    /** The Constant CLAIM_EMPLOYEE_ID. */
    public static final String CLAIM_EMPLOYEE_ID = "employeeId";
    
    /** The Constant CLAIM_USER_IMAGE_PATH. */
    public static final String CLAIM_USER_IMAGE_PATH = "userImagePath";
    
    /** The Constant CLAIM_DEPARTMENT. */
    public static final String CLAIM_DEPARTMENT = "department";
      
	private SecurityContext securityContext;

	public LoggedInUser(SecurityContext securityContext) {
		this.securityContext = securityContext;
	}
    /**
     * Checks if is in role.
     *
     * @param role the role
     * @return true, if is in role
     */
    public boolean isInRole(String role) {
		return securityContext.isUserInRole(role);
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
    	return "";
    }
    
    /**
     * Gets the user firstname.
     *
     * @return the user firstname
     */
    public String getUserFirstname() {
    	return "";
    }
    
    /**
     * Gets the user lastname.
     *
     * @return the user lastname
     */
    public String getUserLastname() {
    	return "";
    }
    
    /**
     * Gets the user firstname lastname.
     *
     * @return the user firstname lastname
     */
    public String getUserFirstnameLastname() {
    	return this.getUserFirstname() + " " + this.getUserLastname();
    }
    
    
    /**
     * Gets the department.
     *
     * @return the department
     */
    public String getDepartment() {
    	return getStringClaim(CLAIM_DEPARTMENT);
    }
    
    /**
     * Gets the string claim.
     *
     * @param claimKey the claim key
     * @return the string claim
     */
    public String getStringClaim(String claimKey) {

        Object claimValue = getClaims().get(claimKey);
        if (claimValue == null) {
			LOG.warning(
					"Cannot get value from authentication token: OAuth2 token does not contain claim '{}' or its value is null "
							+ claimKey);
            return "";
        }
        return String.valueOf(claimValue);
    }

    /**
     * Gets the claims.
     *
     * @return the claims
     */
    private Map<String, Object> getClaims() {

        return null;
    }


}