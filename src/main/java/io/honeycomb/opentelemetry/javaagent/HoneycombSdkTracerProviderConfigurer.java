package io.honeycomb.opentelemetry.javaagent;

import io.honeycomb.opentelemetry.sdk.trace.samplers.DeterministicTraceSampler;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.autoconfigure.spi.SdkTracerProviderConfigurer;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.SdkTracerProviderBuilder;

public class HoneycombSdkTracerProviderConfigurer implements SdkTracerProviderConfigurer {
    @Override
    public void configure(SdkTracerProviderBuilder tracerProviderBuilder) {
        System.out.println("Configuring tracer provider");
        tracerProviderBuilder.setSampler(new DeterministicTraceSampler(5))
            .setResource(Resource.create(Attributes.of(AttributeKey.stringKey("service.name"), "java-autoconfigure-otlp")));
    }
}
