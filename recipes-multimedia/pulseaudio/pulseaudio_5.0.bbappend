
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += " \
    file://pulseaudio.upstart \
    file://pulseaudio.service \
"

SRC_URI += " \
    file://0001-core-make-dependencies-compile-for-64bit.patch \
    file://0002-build-Install-pulsecore-headers.patch \
    file://0003-daemon-Set-default-resampler-to-speex-fixed-2.patch \
    file://0004-bluetooth-Allow-leaving-transport-running-while-sink.patch \
    file://0005-bluetooth-device-Do-not-lose-transport-pointer-after.patch \
    file://0006-bluetooth-device-Default-to-using-A2DP-profile-initi.patch \
    file://0007-module-rescue-streams-Add-parameters-to-define-targe.patch \
    file://0008-bluetooth-util-Detect-transport-acquire-release-loop.patch \
    file://0009-suspend-on-idle-Ensure-we-still-time-out-if-a-stream.patch \
"

do_install_append() {
    install -d ${D}${webos_upstartconfdir}
    install -m 0644 ${WORKDIR}/pulseaudio.upstart ${D}${webos_upstartconfdir}/pulseaudio

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/pulseaudio.service ${D}${systemd_unitdir}/system
}

inherit systemd

SYSTEMD_PACKAGES = "${PN}-server"
SYSTEMD_SERVICE_${PN}-server = "pulseaudio.service"

PACKAGES =+ "${PN}-upstart"
FILES_${PN}-upstart = "${webos_upstartconfdir}"

# Programs using pulseaudio as backend crashed with
#  Assertion 'pthread_mutex_unlock(&m->mutex) == 0' failed at pulsecore/mutex-posix.c:106, function pa_mutex_unlock()
# so we have to drop support for pthread priority inheritance to workaround this problem.
# Actual cause seems to be a problem in eglibc which isn't fixed yet. See:
# - https://github.com/Freescale/meta-fsl-arm/commit/3e6ede30f5da132fc5e2c376c11df661efea7163
# - https://bugs.launchpad.net/ubuntu/+source/pulseaudio/+bug/932096
CACHED_CONFIGUREVARS_append_arm = " ax_cv_PTHREAD_PRIO_INHERIT=no"
