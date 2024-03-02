DESCRIPTION = "MMG base application packagegroup"
SUMMARY = "MMG packagegroup - tools/base-tools"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = " \
	apt \
    ethtool \
	inotify-tools \
	imx-vpuwrap \
	networkmanager \
	libnml \
	cppzmq-dev \
"
