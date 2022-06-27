# Compiles Qt project with cmake after downloading
inherit cmake
inherit cmake_qt5

# AUTOREV references to newest commit
SRCREV = "${AUTOREV}"
LICENSE = "CLOSED"
# LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE.txt;md5=e49f4652534af377a713df3d9dec60cb"

EXTRA_OECMAKE = "-DCOMPILE_MODE=d"

# Reference to repo where to download the software from
SRC_URI = "git://git@github.com/adrianmorente/lazarillo_hmi.git;protocol=ssh"

DEPENDS += " \
        qtbase \
        qtdeclarative \
        qtgraphicaleffects \
        qtmultimedia \
        qtquickcontrols \
        qtquickcontrols2 \
        qtvirtualkeyboard \
        qttools \
        qtxmlpatterns \
        "

RDEPENDS_${PN} += "qtdeclarative-qmlplugins \
        qtgraphicaleffects-qmlplugins \
        qtmultimedia-qmlplugins \
        qtquickcontrols-qmlplugins \
        qtquickcontrols2-qmlplugins \
        qtvirtualkeyboard-qmlplugins \
        "

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${bindir}
    install -m 0700 lazarillo-hmi ${D}${bindir}
}

FILES_${PN} = "${bindir}"
