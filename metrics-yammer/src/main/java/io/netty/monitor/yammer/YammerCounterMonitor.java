/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.monitor.yammer;

import io.netty.monitor.CounterMonitor;

import com.yammer.metrics.core.Counter;

/**
 * <p>
 * An {@link CounterMonitor} that delegates to a <a
 * href="http://metrics.codahale.com/">Yammer</a> {@link Counter}.
 * </p>
 */
class YammerCounterMonitor implements CounterMonitor {

    private final Counter delegate;

    /**
     * @param delegate
     */
    YammerCounterMonitor(final Counter delegate) {
        if (delegate == null) {
            throw new NullPointerException("delegate");
        }
        this.delegate = delegate;
    }

    /**
     * @see io.netty.monitor.CounterMonitor#inc()
     */
    @Override
    public void inc() {
        this.delegate.inc();
    }

    /**
     * @see io.netty.monitor.CounterMonitor#inc(long)
     */
    @Override
    public void inc(final long delta) {
        this.delegate.inc(delta);
    }

    /**
     * @see io.netty.monitor.CounterMonitor#decr()
     */
    @Override
    public void decr() {
        this.delegate.dec();
    }

    /**
     * @see io.netty.monitor.CounterMonitor#decr(long)
     */
    @Override
    public void decr(final long delta) {
        this.delegate.dec(delta);
    }

    /**
     * @see io.netty.monitor.CounterMonitor#reset()
     */
    @Override
    public void reset() {
        this.delegate.clear();
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "YammerCounterMonitor(delegate=" + delegate + ")";
    }
}