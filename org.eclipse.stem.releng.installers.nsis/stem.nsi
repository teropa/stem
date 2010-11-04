; This is the NSIS http://nsis.sourceforge.net/ script that generates an installer for Windows.

!define targetOS "win32"
!define targetARCH "x86"
!define targetWS "win32"
!define targetNL "en"

!define AppName "STEM"
!define AppVersion "unknown"
!define ShortName "STEM"
!define Vendor "IBM"
!define /date MyTIMESTAMP "%Y-%m-%d-%H-%M-%S"
!define InstallFileName "${ShortName}-${AppVersion}-${MyTIMESTAMP}-${targetNL}-${targetARCH}-setup.exe"
!define FileSourcePath "C:\temp\STEM\output\org.eclipse.stem.site.feature_0.0.0-eclipse.feature"
!define FileSourceFolder "stem.${targetWS}.${targetOS}.${targetARCH}.${targetNL}"
!define FileSource "${FileSourcePath}\${FileSourceFolder}"

!include "MUI2.nsh"

Var StartMenuFolder 



;--------------------------------
; Configuration
   ; General
    #AddBrandingImage
    #AllowRootDirInstall true
    #AutoCloseWindow true
    #BGFont
    #BGGradient
    #BGGradient
    #BrandingText /TRIMLEFT "${AppName}"
    #Caption
    #ChangeUI
    #CheckBitma
    #CompletedText
    #ComponentText
    #CRCCheck
    #DetailsButton
    #DirText
    #DirVar
    #DirVerity
    #FileErrorText
    #Icon
    #InstallButtonText
    #InstallColors
    #InstallDir "$PROGRAMFILES\${SHORTNAME}"
    InstallDir "c:\temp\${SHORTNAME}\${targetNL}\${MyTIMESTAMP}"
    #InstallDirRegKey
    #InstProgressFlags
    #InstType
    #LicenseBkColor
    #LicenseData
    #LicenseForceSelection checkbox
    #LicenseText
    #MiscButtonText
    Name "${AppName}"
    Outfile "${InstallFileName}"
    RequestExecutionLevel user
    #SetFont
    #ShowInstDetails on
    #ShowUninstDetails
    #SilentInstall
    #SpaceTexts
    #SubCaption
    #UninstallButtonText
    #UninstallCaption
    #UninstallIcon
    #UninstallSubCaption
    #UninstallText
    #WindowIcon
    #XPStyle on
   
   ; Version Information
   ; These will appear in the File Properties
    #VIAddVersionKey /LANG=${LANG_ENGLISH} "ProductName" "${AppName}"
    #VIAddVersionKey /LANG=${LANG_ENGLISH} "Comments" ""
    #VIAddVersionKey /LANG=${LANG_ENGLISH} "CompanyName" ""
    #VIAddVersionKey /LANG=${LANG_ENGLISH} "LegalCopyright" ""
    #VIAddVersionKey /LANG=${LANG_ENGLISH} "FileDescription" ""
    #VIAddVersionKey /LANG=${LANG_ENGLISH} "FileVersion" ""
    #VIAddVersionKey /LANG=${LANG_ENGLISH} "ProductVersion" "${AppVersion}"
    #VIAddVersionKey /LANG=${LANG_ENGLISH} "InternalName" ""
    #VIAddVersionKey /LANG=${LANG_ENGLISH} "LegalTrademarks" ""
    #VIAddVersionKey /LANG=${LANG_ENGLISH} "OriginalFilename" ""
    #VIAddVersionKey /LANG=${LANG_ENGLISH} "PrivateBuild" ""
    #VIAddVersionKey /LANG=${LANG_ENGLISH} "SpecialBuild" ""
   
;--------------------------------
; Pages
    ; Welcome Page
    !insertmacro MUI_PAGE_WELCOME
    
    ; License Page
    !insertmacro MUI_PAGE_LICENSE "license.txt"
    
    ; Componets To Install Page(?)
    #!insertmacro MUI_PAGE_COMPONENTS
 
    ; Install Directory Selection Page(?)
    !insertmacro MUI_PAGE_DIRECTORY
       
    ; Start Menu Directory Selection Page(?)
    !insertmacro MUI_PAGE_STARTMENU "STEM" $StartMenuFolder
    
    
    ; Install Pages
    !insertmacro MUI_PAGE_INSTFILES 
        !define MUI_INSTFILESPAGE_FINISHHEADER_TEXT "Installation Complete"
        !define MUI_PAGE_HEADER_TEXT "Installing"
        !define MUI_PAGE_HEADER_SUBTEXT "Please wait while ${AppName} is being installed."
    #!define MUI_PAGE_CUSTOMFUNCTION_PRE
 
    !insertmacro MUI_PAGE_FINISH
    
    ; Uninstall Pages
    #!insertmacro MUI_UNPAGE_WELCOME
    #!insertmacro MUI_UNPAGE_CONFIRM
    #!insertmacro MUI_UNPAGE_COMPONENTS
    #!insertmacro MUI_UNPAGE_DIRECTORY
    #!insertmacro MUI_UNPAGE_INSTFILES
    #!insertmacro MUI_UNPAGE_FINISH


;--------------------------------
; Languages

    !insertmacro MUI_LANGUAGE "English"
    
;--------------------------------
; Language Strings

    ; Description
    LangString DESC_SecAppFiles ${LANG_ENGLISH} "Application files copy"  

;--------------------------------
; Installer Sections

Section # Hidden

SetOutPath $INSTDIR

File /r ${FileSource}\*

# Start Menu Items and Shortcuts
CreateDirectory "$SMPROGRAMS\${AppName}"
CreateShortCut "$SMPROGRAMS\${AppName}\${ShortName}.lnk" "$INSTDIR\stem.exe"


SectionEnd


#Section "Uninstall"

; Delete the files and folders we created during install
; ...
; ...
; ...
; Now remove shortcuts too
#Delete "$SMPROGRAMS\${AppName}\${ShortName}.lnk"
#RMDIR "$SMPROGRAMS\${AppName}"

#SectionEnd ; end the section
 

