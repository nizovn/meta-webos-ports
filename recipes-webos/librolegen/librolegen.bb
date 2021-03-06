# Copyright (c) 2012-2014 LG Electronics, Inc.

SUMMARY = "Library for dynamically generating webOS system bus role files for webOS JavaScript services"
SECTION = "webos/libs"
AUTHOR = "Seokhyon Seong <seokhyon.seong@lge.com>"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

WEBOS_VERSION = "2.1.0-20_cef54033f9a0e6a2c0dbf0c8cf3f9fcbb39979d9"

inherit webos_component
inherit webos_public_repo
inherit webos_enhanced_submissions 
inherit webos_cmake
inherit webos_library

SRC_URI = "${OPENWEBOS_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"

FILES_${PN} += "${datadir}/rolegen"

inherit webos-ports-submissions
SRCREV = "196510e255ba809370b788b2f0010acf9f84b488"
