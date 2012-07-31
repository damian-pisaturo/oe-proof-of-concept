import com.crmco.crm.Role
import com.crmco.crm.User
import com.crmco.crm.UserRole

class BootStrap {

    def init = { servletContext ->

		/*
		 * FIXME: BEGIN of test code. Remove this after the first running!!
		 */
//      def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
//      def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
//
//      def testUser = new User(username: 'admin', enabled: true, password: 'admin')
//      testUser.save(flush: true)
//
//      UserRole.create testUser, adminRole, true
//
//      assert User.count() == 1
//      assert Role.count() == 2
//      assert UserRole.count() == 1
	  /*
	   * END of test code.
	   */
	  
   }
	
    def destroy = {
    }
}
