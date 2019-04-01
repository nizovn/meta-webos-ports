SUMMARY = "Anonymous Shared Memory Subsystem, ashmem"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://ashmem.c;endline=17;md5=c74d8e70552b07bbd79f07120b792292"

SRCREV = "27fd47e11ef6eef93738f8f3df3e42c88975544e"
PV = "3.0+git${SRCPV}"

inherit module

SRC_URI = "git://github.com/anbox/anbox-modules \
    file://0001-ashmem-binder-add-modules_install-target-to-Makefile.patch;patchdir=.. \
"

S = "${WORKDIR}/git/ashmem"

do_install_append() {
    install -d ${D}${sysconfdir}/udev/rules.d
    grep ashmem ${S}/../99-anbox.rules > ${D}${sysconfdir}/udev/rules.d/99-ashmem.rules
}

KERNEL_MODULE_AUTOLOAD += "ashmem_linux"

FILES_${PN} += "${sysconfdir}/udev"
