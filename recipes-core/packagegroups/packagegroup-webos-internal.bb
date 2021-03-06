# Copyright (c) 2012-2013 LG Electronics, Inc.

DESCRIPTION = "Internal components used in Open webOS"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

# You don't need to change this value when you're changing just RDEPENDS_${PN} variable.

PACKAGE_ARCH = "${MACHINE_ARCH}"
inherit packagegroup

# to replace task-webos-internal by packagegroup-webos-internal during upgrade on target
RPROVIDES_${PN} = "task-webos-internal"
RREPLACES_${PN} = "task-webos-internal"
RCONFLICTS_${PN} = "task-webos-internal"

RDEPENDS_${PN} = " \
"
