require recipes-images/images/tdx-reference-minimal-image.bb

SUMMARY = "MMG Minimal Image"

#Prefix to the resulting deployable tarball name
export IMAGE_BASENAME = "MMG-Minimal-Image"

# using en-gb instead of en-us
IMAGE_LINGUAS = "en-gb"

# swap dropbear for openssh
TASK_BASIC_SSHDAEMON = "openssh-sshd openssh-sftp openssh-sftp-server"

# add openssh
IMAGE_FEATURES += " \
	package-management \
	ssh-server-openssh \
"

# add some custom packages from the multimedia image
IMAGE_INSTALL += " \
	packagegroup-mmg-base \
	packagegroup-fsl-gstreamer1.0-full \
	packagegroup-base-tdx-cli \
	packagegroup-core-ssh-openssh \
	${@bb.utils.contains("MACHINE_FEATURES", "tpm2", "packagegroup-tpm2-tdx-cli", "",d)} \
"

# Going to use networkmanager instead of conman
IMAGE_INSTALL:remove = " ${CONMANPKGS}"

# Add NetworkManager
IMAGE_INSTALL:append = " networkmanager"
IMAGE_INSTALL:append = " modemmanager"
