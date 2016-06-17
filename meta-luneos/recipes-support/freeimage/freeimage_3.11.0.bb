do_unpack[depends] += "unzip-native:do_populate_sysroot"

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/freeimage/FreeImage3110.zip"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = " \
    file://license-fi.txt;md5=8e1438cab62c8f655288588dc43daaf6 \
    file://license-gpl.txt;md5=53b6c3648a3732688e86c8a7373c6924 \
"

S = "${WORKDIR}/FreeImage/"

TARGET_CC_ARCH += "${LDFLAGS}"

do_configure() {
    sed -i -e /^CC/d \
           -e /^CXX\ /d \
           -e /^AR/d \
           -e /^INCDIR\ /d \
           -e /^INSTALLDIR\ /d \
           -e s:'-o root -g root'::g \
           -e /ldconfig/d \
    ${S}/Makefile.gnu
}

do_install() {
    install -d ${D}${libdir}
    install -d ${D}${includedir}
    oe_runmake INSTALLDIR="${D}${libdir}" INCDIR="${D}${includedir}" install
}

INSANE_SKIP_${PN} = "already-stripped"

FILES_${PN} += "${libdir}"
FILES_SOLIBSDEV = "${libdir}/lib${PN}.so"

SRC_URI[md5sum] = "ad1db36414391417654ba7bf1c0277d3"
SRC_URI[sha256sum] = "84021b8c0b86e5801479474ad9a99c18d121508ee16d363e02ddcbf24195340c"
