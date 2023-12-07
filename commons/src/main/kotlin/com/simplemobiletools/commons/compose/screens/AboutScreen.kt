package com.simplemobiletools.commons.compose.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.simplemobiletools.commons.R
import com.simplemobiletools.commons.compose.extensions.MyDevices
import com.simplemobiletools.commons.compose.settings.SettingsGroup
import com.simplemobiletools.commons.compose.settings.SettingsHorizontalDivider
import com.simplemobiletools.commons.compose.settings.SettingsListItem
import com.simplemobiletools.commons.compose.settings.SettingsTitleTextComponent
import com.simplemobiletools.commons.compose.settings.scaffold.SettingsScaffold
import com.simplemobiletools.commons.compose.theme.AppThemeSurface

private val startingTitlePadding = Modifier.padding(start = 58.dp)

@Composable
internal fun AboutScreen(
    goBack: () -> Unit,
    helpUsSection: @Composable () -> Unit,
    aboutSection: @Composable () -> Unit,
    socialSection: @Composable () -> Unit,
    otherSection: @Composable () -> Unit,
    canScroll: (canPerformScroll: Boolean) -> Unit,
) {
    SettingsScaffold(title = stringResource(id = R.string.about), goBack = goBack, canScroll = canScroll) { paddingValues ->
        aboutSection()
        helpUsSection()
        socialSection()
        otherSection()
        SettingsListItem(text = stringResource(id = R.string.about_footer))
        Spacer(modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding()))
    }
}

@Composable
internal fun HelpUsSection(
    onContributorsClick: () -> Unit
) {
    SettingsGroup(title = {
        SettingsTitleTextComponent(text = stringResource(id = R.string.help_us), modifier = startingTitlePadding)
    }) {
        SettingsListItem(
            tint = MaterialTheme.colorScheme.onSurface,
            click = onContributorsClick,
            text = stringResource(id = R.string.contributors),
            icon = R.drawable.ic_face_vector
        )
        SettingsHorizontalDivider()
    }
}

@Composable
internal fun OtherSection(
    showMoreApps: Boolean,
    onMoreAppsClick: () -> Unit,
    onWebsiteClick: () -> Unit,
    showWebsite: Boolean,
    showPrivacyPolicy: Boolean,
    onPrivacyPolicyClick: () -> Unit,
    onLicenseClick: () -> Unit,
    version: String,
    onVersionClick: () -> Unit,
) {
    SettingsGroup(title = {
        SettingsTitleTextComponent(text = stringResource(id = R.string.other), modifier = startingTitlePadding)
    }) {
        if (showMoreApps) {
            SettingsListItem(
                tint = MaterialTheme.colorScheme.onSurface,
                click = onMoreAppsClick,
                text = stringResource(id = R.string.more_apps_from_us),
                icon = R.drawable.ic_heart_vector
            )
        }
        if (showWebsite) {
            SettingsListItem(
                tint = MaterialTheme.colorScheme.onSurface,
                click = onWebsiteClick,
                text = stringResource(id = R.string.website),
                icon = R.drawable.ic_link_vector
            )
        }
        if (showPrivacyPolicy) {
            SettingsListItem(
                tint = MaterialTheme.colorScheme.onSurface,
                click = onPrivacyPolicyClick,
                text = stringResource(id = R.string.privacy_policy),
                icon = R.drawable.ic_unhide_vector
            )
        }
        SettingsListItem(
            tint = MaterialTheme.colorScheme.onSurface,
            click = onLicenseClick,
            text = stringResource(id = R.string.third_party_licences),
            icon = R.drawable.ic_article_vector
        )
        SettingsListItem(tint = MaterialTheme.colorScheme.onSurface, click = onVersionClick, text = version, icon = R.drawable.ic_info_vector)
        SettingsHorizontalDivider()
    }
}


@Composable
internal fun AboutSection(
    setupFAQ: Boolean,
    onFAQClick: () -> Unit,
    onEmailClick: () -> Unit,
    onUpstreamClick: () -> Unit
) {
    SettingsGroup(title = {
        SettingsTitleTextComponent(text = stringResource(id = R.string.support), modifier = startingTitlePadding)
    }) {
        if (setupFAQ) {
            SettingsListItem(
                tint = MaterialTheme.colorScheme.onSurface,
                click = onFAQClick,
                text = stringResource(id = R.string.frequently_asked_questions),
                icon = R.drawable.ic_question_mark_vector
            )
        }
        SettingsListItem(
            tint = MaterialTheme.colorScheme.onSurface,
            click = onEmailClick,
            text = stringResource(id = R.string.my_email),
            icon = R.drawable.ic_mail_vector
        )
        SettingsListItem(
            tint = MaterialTheme.colorScheme.onSurface,
            click = onUpstreamClick,
            text = stringResource(id = R.string.upstream),
            icon = R.drawable.ic_link_vector
        )
        SettingsHorizontalDivider()
    }
}

@Composable
internal fun SocialSection(
    onGithubClick: () -> Unit
) {
    SettingsGroup(title = {
        SettingsTitleTextComponent(text = stringResource(id = R.string.social), modifier = startingTitlePadding)
    }) {
        SettingsListItem(
            click = onGithubClick,
            text = stringResource(id = R.string.github),
            icon = R.drawable.ic_github_vector,
            isImage = true,
            tint = MaterialTheme.colorScheme.onSurface
        )
        SettingsHorizontalDivider()
    }
}

@MyDevices
@Composable
private fun AboutScreenPreview() {
    AppThemeSurface {
        AboutScreen(
            goBack = {},
            aboutSection = {
                AboutSection(setupFAQ = true, onFAQClick = {}, onEmailClick = {}, onUpstreamClick = {})
            },
            helpUsSection = {
                HelpUsSection(
                    onContributorsClick = {}
                )
            },
            socialSection = {
                SocialSection(
                    onGithubClick = {}
                )
            },
            otherSection = {
                OtherSection(
                    showMoreApps = true,
                    onMoreAppsClick = {},
                    onWebsiteClick = {},
                    showWebsite = true,
                    showPrivacyPolicy = true,
                    onPrivacyPolicyClick = {},
                    onLicenseClick = {},
                    version = "5.0.4",
                    onVersionClick = {}
                )
            }, canScroll = {}
        )
    }
}
