SUMMARY = "Simple service to retrieve, set and get notified about android properties."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://README.md;beginline=86;endline=105;md5=649a1e756b7d4ea0e24d38c2d5a572ee"

DEPENDS += "luna-service2 virtual/libandroid-properties libpbnjson"

inherit webos_component
inherit webos_public_repo
inherit webos_cmake
inherit webos_daemon
inherit webos_system_bus
inherit webos_systemd

WEBOS_COMPONENT_VERSION = "0.1.0"
PV = "${WEBOS_COMPONENT_VERSION}+gitr${SRCPV}"
WEBOS_SUBMISSION = "0"
SRCREV = "30fcbef495a0037c73075e58f1fd9b1c8b790b1d"

SRC_URI = "git://github.com/webOS-ports/android-property-service;branch=master;protocol=git"
S = "${WORKDIR}/git"
