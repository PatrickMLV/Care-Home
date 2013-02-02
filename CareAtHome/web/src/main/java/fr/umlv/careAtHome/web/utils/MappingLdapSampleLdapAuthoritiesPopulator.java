//package fr.umlv.careAtHome.web.utils;
//
//import org.apache.log4j.Logger;
//import org.springframework.asm.Attribute;
//import org.springframework.ldap.core.DirContextOperations;
//import org.springframework.security.GrantedAuthority;
//import org.springframework.security.GrantedAuthorityImpl;
//import org.springframework.security.ldap.LdapAuthoritiesPopulator;
//
//import java.util.Properties;
//
//public class MappingLdapSampleLdapAuthoritiesPopulator implements
//		LdapAuthoritiesPopulator {
//	private static final Logger LOGGER = Logger
//			.getLogger(MappingLdapSampleLdapAuthoritiesPopulator.class);
//
//	private static final int DEBUT_CHAINE = 3;
//
//	private Properties rolesMapping;
//
//	public MappingLdapSampleLdapAuthoritiesPopulator(Properties rolesMapping) {
//		this.rolesMapping = rolesMapping;
//	}
//
//	public GrantedAuthority[] getGrantedAuthorities(
//			DirContextOperations userData, String username) {
//		String[] ldapRoles = userData.getStringAttributes("ou");
//
//		for (int i = 0; i < ldapRoles.length; ++i) {
//			System.out.println("LDAP memberOf attribute: " + ldapRoles[i]);
//			ldapRoles[i] = ldapRoles[i].substring(DEBUT_CHAINE);
//		}
//
//		GrantedAuthority[] authorities = new GrantedAuthorityImpl[ldapRoles.length];
//
//		for (int i = 0; i < ldapRoles.length; ++i) {
//			String mappedRole = this.rolesMapping.getProperty(ldapRoles[i]);
//			if (mappedRole != null) {
//				System.out.println("Mapping ldap role " + ldapRoles[i] + " to "
//						+ mappedRole);
//				authorities[i] = new GrantedAuthorityImpl(mappedRole);
//			} else {
//				authorities[i] = new GrantedAuthorityImpl("ROLE_"
//						+ ldapRoles[i]);
//			}
//			System.out.println("Spring Security role: "
//					+ authorities[i].getAuthority());
//		}
//		return authorities;
//	}
//}
