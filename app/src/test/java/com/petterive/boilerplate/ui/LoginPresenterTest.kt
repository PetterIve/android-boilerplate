package com.petterive.boilerplate.ui

import com.petterive.boilerplate.data.LoginMutations
import com.petterive.boilerplate.data.LoginState
import com.petterive.boilerplate.model.app.Loadable
import com.petterive.boilerplate.model.app.ModelSet
import com.petterive.boilerplate.model.app.NotInitialized
import com.petterive.boilerplate.ui.login.LoginPresenter
import com.petterive.boilerplate.ui.login.LoginView
import com.petterive.model.User
import com.petterive.model.app.ServerError
import io.reactivex.subjects.BehaviorSubject
import org.junit.Test
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.plugins.RxAndroidPlugins
import org.junit.AfterClass
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import io.reactivex.plugins.RxJavaPlugins





/**
 * Created by petteriversen on 04/02/2018.
 */

class LoginPresenterTest {

    companion object {
        @BeforeClass
        @JvmStatic
        fun setupClass() {
            RxAndroidPlugins.setInitMainThreadSchedulerHandler { _ -> Schedulers.trampoline() }
            RxJavaPlugins.setIoSchedulerHandler { _ -> Schedulers.trampoline() }
            RxJavaPlugins.setComputationSchedulerHandler { _ -> Schedulers.trampoline() }
            RxJavaPlugins.setNewThreadSchedulerHandler { _ -> Schedulers.trampoline() }
        }
        @AfterClass
        @JvmStatic fun teardown() {
            RxAndroidPlugins.reset()
        }
    }

    @Test
    fun `Should update view after successful login` () {
        val mockState = MockLoginState()
        val mockMutations = MockLoginMutations(mockState)
        val mockView = MockLoginView()
        val presenter = LoginPresenter(mockMutations, mockState)
        presenter.attachToView(mockView)
        presenter.login("test", "test");
        assertEquals(true, mockView.onLoginSuccessWasCalled)
    }

    class MockLoginMutations(val mockState: LoginState): LoginMutations {
        override fun doLogin(username: String, password: String) {
            val user = ModelSet(User(username, password))
            mockState.updateLoginState(user)
        }
    }

    class MockLoginState: LoginState {
        override val userSubject: BehaviorSubject<Loadable<User>> = BehaviorSubject.createDefault(NotInitialized())

        override fun updateLoginState(newState: Loadable<User>) {
            userSubject.onNext(newState)
        }
    }

    class MockLoginView: LoginView {
        var onLoginSuccessWasCalled: Boolean = false

        override fun onLoginSuccess(model: User) {
            onLoginSuccessWasCalled = true
        }

        override fun showLoggingIn() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun showAwaitingUserInput() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun showForgotEmail() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun showLoginError(serverError: ServerError) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

}