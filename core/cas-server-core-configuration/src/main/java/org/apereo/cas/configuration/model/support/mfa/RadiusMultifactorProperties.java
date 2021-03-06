package org.apereo.cas.configuration.model.support.mfa;

import org.apereo.cas.configuration.model.support.radius.RadiusClientProperties;
import org.apereo.cas.configuration.model.support.radius.RadiusServerProperties;
import org.apereo.cas.configuration.support.RequiredModule;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * This is {@link RadiusMultifactorProperties}.
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiredModule(name = "cas-server-support-radius-mfa")
public class RadiusMultifactorProperties extends BaseMultifactorProviderProperties {
    private static final long serialVersionUID = 7021301814775348087L;
    /**
     * In the event that radius authentication fails due to a catastraphic event,
     * fail over to the next server in the list.
     */
    private boolean failoverOnException;
    /**
     * In the event that radius authentication fails,
     * fail over to the next server in the list.
     */
    private boolean failoverOnAuthenticationFailure;

    /**
     * RADIUS server settings.
     */
    @NestedConfigurationProperty
    private RadiusServerProperties server = new RadiusServerProperties();

    /**
     * RADIUS client settings.
     */
    @NestedConfigurationProperty
    private RadiusClientProperties client = new RadiusClientProperties();

    /**
     * Indicates whether this provider should support trusted devices.
     */
    private boolean trustedDeviceEnabled;

    public RadiusMultifactorProperties() {
        setId("mfa-radius");
    }

    public boolean isTrustedDeviceEnabled() {
        return trustedDeviceEnabled;
    }

    public void setTrustedDeviceEnabled(final boolean trustedDeviceEnabled) {
        this.trustedDeviceEnabled = trustedDeviceEnabled;
    }

    public boolean isFailoverOnException() {
        return failoverOnException;
    }

    public void setFailoverOnException(final boolean failoverOnException) {
        this.failoverOnException = failoverOnException;
    }

    public boolean isFailoverOnAuthenticationFailure() {
        return failoverOnAuthenticationFailure;
    }

    public void setFailoverOnAuthenticationFailure(final boolean failoverOnAuthenticationFailure) {
        this.failoverOnAuthenticationFailure = failoverOnAuthenticationFailure;
    }

    public RadiusServerProperties getServer() {
        return server;
    }

    public void setServer(final RadiusServerProperties server) {
        this.server = server;
    }

    public RadiusClientProperties getClient() {
        return client;
    }

    public void setClient(final RadiusClientProperties client) {
        this.client = client;
    }
}
