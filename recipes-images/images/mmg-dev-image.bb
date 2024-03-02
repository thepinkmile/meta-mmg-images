require mmg-prod-image.bb

SUMMARY = "MMG Development Image"

#Prefix to the resulting deployable tarball name
export IMAGE_BASENAME = "MMG-Minimal-Dev-Image"

IMAGE_FEATURES += " tools-debug debug-tweaks"

IMAGE_INSTALL += " \
	packagegroup-mmg-testapps \
	packagegroup-devel-tdx-cli \
"
