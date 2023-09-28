package com.abulnes.trucker_app.navigation.auth

interface AuthDestinations {
    val route: String
}

object SignUp : AuthDestinations {
    override val route: String = "SignUp"

}

object SignIn : AuthDestinations {
    override val route: String = "SignIn"

}

object ForgotPassword : AuthDestinations {
    override val route: String = "ForgotPassword"
}

object Welcome : AuthDestinations {
    override val route: String = "Welcome"
}


object CreatePassword : AuthDestinations {
    override val route: String = "CreatePassword"
}