package com.devcorr.android.sbb;

import android.accounts.AccountManager;
import android.content.Context;

import com.devcorr.android.sbb.authenticator.BootstrapAuthenticatorActivity;
import com.devcorr.android.sbb.authenticator.LogoutService;
import com.devcorr.android.sbb.core.TimerService;
import com.devcorr.android.sbb.ui.BootstrapTimerActivity;
import com.devcorr.android.sbb.ui.MainActivity;
import com.devcorr.android.sbb.ui.CheckInsListFragment;
import com.devcorr.android.sbb.ui.NavigationDrawerFragment;
import com.devcorr.android.sbb.ui.NewsActivity;
import com.devcorr.android.sbb.ui.NewsListFragment;
import com.devcorr.android.sbb.ui.UserActivity;
import com.devcorr.android.sbb.ui.UserListFragment;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module for setting up provides statements.
 * Register all of your entry points below.
 */
@Module(
        complete = false,

        injects = {
                BootstrapApplication.class,
                BootstrapAuthenticatorActivity.class,
                MainActivity.class,
                BootstrapTimerActivity.class,
                CheckInsListFragment.class,
                NavigationDrawerFragment.class,
                NewsActivity.class,
                NewsListFragment.class,
                UserActivity.class,
                UserListFragment.class,
                TimerService.class
        }
)
public class BootstrapModule {

    @Singleton
    @Provides
    Bus provideOttoBus() {
        return new Bus();
    }

    @Provides
    @Singleton
    LogoutService provideLogoutService(final Context context, final AccountManager accountManager) {
        return new LogoutService(context, accountManager);
    }

}
